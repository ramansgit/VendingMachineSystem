package com.vending.exception;


public class ProductExistException extends Exception {
    private String message;
   
    public ProductExistException(String string) {
        this.message = string;
    }
   
    @Override
    public String getMessage(){
        return message;
    }
   
}