package com.example.shopyverse.Service;


import com.example.shopyverse.Dto.Request.SellerRequestDto;
import com.example.shopyverse.Dto.Response.SellerResponseDto;
import com.example.shopyverse.Model.Seller;
import com.example.shopyverse.Repository.SellerRepository;
import com.example.shopyverse.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        // dto -> entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        // save the entity
        Seller savedSeller = sellerRepository.save(seller);

        // prepare response dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }
}