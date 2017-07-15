package com.vending.exception;
/**
 * SoldOutException throws when product not available
 * @author ramans
 *
 */
public class SoldOutException extends Exception {
    private String message;
   
    public SoldOutException(String string) {
        this.message = string;
    }
   
    @Override
    public String getMessage(){
        return message;
    }
   
}
