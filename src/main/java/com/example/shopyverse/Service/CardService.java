package com.example.shopyverse.Service;

import com.example.shopyverse.Dto.Request.CardRequestDto;
import com.example.shopyverse.Dto.Response.CardResponseDto;
import com.example.shopyverse.Excepition.CustomerNotFoundException;
import com.example.shopyverse.Model.Card;
import com.example.shopyverse.Model.Customer;
import com.example.shopyverse.Repository.CustomerRepository;
import com.example.shopyverse.Transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto){

        Customer customer = customerRepository.findByMobNo(cardRequestDto.getCustomerMobile());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        // create card entity
        Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        Customer savedCustomer = customerRepository.save(customer);
        List<Card> cards = savedCustomer.getCards();
        Card latestCard = cards.get(cards.size()-1);

        // prepare card response dto
        CardResponseDto cardResponseDto = CardTransformer.CardToCardResponseDto(latestCard);
        cardResponseDto.setCardNo(generateMaskedCard(latestCard.getCardNo()));

        return cardResponseDto;
    }

    public String generateMaskedCard(String cardNo){
        int cardLength = cardNo.length();
        String maskedCard = "";
        for(int i = 0;i<cardLength-4;i++){
            maskedCard += 'X';
        }

        maskedCard += cardNo.substring(cardLength-4);
        return maskedCard;
    }
}
