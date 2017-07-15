package com.vending.exception;
/**
 * NotSufficientChangeException when unable to dispense change
 * @author ramans
 *
 */
public class NotSufficientChangeException extends Exception {
    private String message;
   
    public NotSufficientChangeException(String string) {
        this.message = string;
    }
   
    @Override
    public String getMessage(){
        return message;
    }
   
}