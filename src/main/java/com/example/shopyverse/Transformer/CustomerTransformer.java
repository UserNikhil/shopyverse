package com.example.shopyverse.Transformer;

import com.example.shopyverse.Dto.Request.CustomerRequestDto;
import com.example.shopyverse.Dto.Response.CustomerResponseDto;
import com.example.shopyverse.Model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto)
    {

        return Customer.builder().
                name(customerRequestDto.getName()).
                gender(customerRequestDto.getGender()).
                emailId(customerRequestDto.getEmailId()).
                mobNo(customerRequestDto.getMobNo()).
                build();
    }

    public static CustomerResponseDto CustomerResponseDtoToCustomer(Customer customer)
    {
        return CustomerResponseDto.builder().
                name(customer.getName()).
                emailId(customer.getEmailId()).
                mobNo(customer.getMobNo()).
                gender(customer.getGender()).build();
    }
}
