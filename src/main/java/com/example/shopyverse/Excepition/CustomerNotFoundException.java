package com.example.shopyverse.Excepition;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){

        super(message);
    }
}