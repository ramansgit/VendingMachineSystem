package com.vending.utils;

import java.util.HashMap;
import java.util.Map;

public class VendeningMachine {
	public static final Map<Integer, Integer> cash = new HashMap<Integer, Integer>();
	public static final Map<Integer, Integer> insertCoin = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		cash.put(1, 5);
		cash.put(2, 10);
		cash.put(5, 15);
		cash.put(10, 10);
		cash.put(20, 18);
		cash.put(50, 40);
		cash.put(100, 20);
		cash.put(200, 20);
		cash.put(500, 20);
		cash.put(2000, 25);
		
		//total purchase = 800
		
		
		// insert coin
		insertCoin.put(1, 5);
		insertCoin.put(5, 5);
		insertCoin.put(10, 5);
		insertCoin.put(100, 5);
		
		// total = 580 rs
		

		
		
		
	}
	 private boolean isFullPaid() {
	        if(true){
	            return true;
	        }
	        return false;
	    }

	
	

}