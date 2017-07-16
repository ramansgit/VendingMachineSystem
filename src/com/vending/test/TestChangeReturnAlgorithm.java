package com.vending.test;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.vending.exception.NotSufficientChangeException;
import com.vending.model.CashEnum;

public class TestChangeReturnAlgorithm {

	public static void main(String[] args) throws NotSufficientChangeException {
		new TestChangeReturnAlgorithm().getChange(1733);

	}

	/**
	 * checks whether change available in the store to dispense . if not returns
	 * expections
	 * 
	 * @param amount
	 * @return
	 * @throws NotSufficientChangeException
	 */
	public Map<CashEnum, Integer> getChange(int amount) throws NotSufficientChangeException {
		int balance = amount;

		Map<CashEnum, Integer> cashStore = getCashDenominations();
		Map<CashEnum, Integer> changeDenomiations = new TreeMap<>(Collections.reverseOrder());
		int count = 0;
		Set<CashEnum> keys = cashStore.keySet();
		for (CashEnum key : keys) {
			if (balance >= key.getValue()) {
				count = cashStore.get(key);
				balance = getBalance(cashStore,changeDenomiations, key, balance, count);
			}
		}
		if (balance > 0) {
			throw new NotSufficientChangeException("NotSufficientChange,Please try another product");
		}
		System.out.println(cashStore);
		System.out.println(changeDenomiations);
	
		return changeDenomiations;
	}
	
	

	/**
	 * find the balance
	 * @param cash
	 * @param changeDenomiations
	 * @param type
	 * @param balance
	 * @param count
	 * @return
	 */
	public int getBalance(Map<CashEnum, Integer> cash,Map<CashEnum, Integer> changeDenomiations, CashEnum type, int balance, int count) {
		// 0, 1,2 ,3 ,4 ,5
		int denomination = type.getValue();
		int div = balance / denomination; // 1,2,3,4,5...
		if (count == 0) {
			return balance;
		}
		if (div >= count) {
			balance = balance - (denomination * count);
			changeDenomiations.put(type, count);
			count = 0;
			cash.put(type, count);
			
			return balance;
		} else {
			balance = balance - (denomination * div);
			count = count - div;
			cash.put(type, count);
			changeDenomiations.put(type, div);
			return balance;
		}
	}

	public Map<CashEnum, Integer> getCashDenominations() {
		Map<CashEnum, Integer> cash = new TreeMap<CashEnum, Integer>(Collections.reverseOrder());
		cash.put(CashEnum.ONE, 10);
		cash.put(CashEnum.TWO, 10);
		cash.put(CashEnum.FIVE, 15);
		cash.put(CashEnum.TEN, 10);
		cash.put(CashEnum.TWENTY, 18);
		cash.put(CashEnum.FIFTY, 0);
		cash.put(CashEnum.HUNDRED, 0);
		cash.put(CashEnum.FIVEHUNDRED, 4);
		cash.put(CashEnum.TWOTHOUSAND, 4);

		return cash;
	}
}