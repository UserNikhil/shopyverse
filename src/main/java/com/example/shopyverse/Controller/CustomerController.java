package com.example.shopyverse.Controller;


import com.example.shopyverse.Dto.Request.CustomerRequestDto;
import com.example.shopyverse.Dto.Response.CustomerResponseDto;
import com.example.shopyverse.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto)
    {
        CustomerResponseDto response=customerService.addCustomer(customerRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
