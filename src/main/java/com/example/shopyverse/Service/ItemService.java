package com.example.shopyverse.Service;

import com.example.shopyverse.Dto.Request.ItemRequestDto;
import com.example.shopyverse.Excepition.CustomerNotFoundException;
import com.example.shopyverse.Excepition.InsufficientQuantityException;
import com.example.shopyverse.Excepition.ProductNotFoundException;
import com.example.shopyverse.Model.Customer;
import com.example.shopyverse.Model.Item;
import com.example.shopyverse.Model.Product;
import com.example.shopyverse.Repository.CustomerRepository;
import com.example.shopyverse.Repository.ProductRepository;
import com.example.shopyverse.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;
    public Item createItem(ItemRequestDto itemRequestDto) {

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exisit");
        }

        Optional<Product> productOptional = productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exist");
        }

        Product product = productOptional.get();

        // check for required quantity
        if(product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! Required quantity not avaiable");
        }

        // create item
        Item item = ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;
    }
}