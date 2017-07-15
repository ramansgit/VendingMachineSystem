package com.vending.exception;
/**
 * NotFullPaidException when user not paid cash
 * @author ramans
 *
 */
public class NotFullPaidException extends Exception {
    private String message;
    private long remaining;
   
    public NotFullPaidException(String message, long remaining) {
        this.message = message;
        this.remaining = remaining;
    }
   
    public long getRemaining(){
        return remaining;
    }
   
    @Override
    public String getMessage(){
        return message + remaining;
    } 
   
}