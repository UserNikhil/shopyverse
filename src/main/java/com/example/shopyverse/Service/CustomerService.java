package com.example.shopyverse.Service;


import com.example.shopyverse.Dto.Request.CustomerRequestDto;
import com.example.shopyverse.Dto.Response.CustomerResponseDto;
import com.example.shopyverse.Model.Cart;
import com.example.shopyverse.Model.Customer;
import com.example.shopyverse.Repository.CustomerRepository;
import com.example.shopyverse.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

//        Customer customer=new Customer();
//        customer.setName(customerRequestDto.getName());
//        customer.setEmailId(customerRequestDto.getEmailId());
//        customer.setGender(customerRequestDto.getGender());
//        customer.setMobNo(customerRequestDto.getMobNo());

        Customer customer= CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);
        Cart cart=new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);

        Customer savedCustomer=customerRepository.save(customer);

        return CustomerTransformer.CustomerResponseDtoToCustomer(savedCustomer);
    }
}
