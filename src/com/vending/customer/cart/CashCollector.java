package com.vending.customer.cart;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.vending.model.CashEnum;
import com.vending.model.Item;

/**
 * class responsible for managing user cash for the transaction.
 * 
 * @author ramans
 *
 */
public class CashCollector {

	public static CashCollector instance = null;
	/**
	 * collects user cash for the transaction
	 */
	private Map<CashEnum, Integer> userCashStore = new TreeMap<CashEnum, Integer>(Collections.reverseOrder());

	private CashCollector() {

	}

	/**
	 * singleton pattern followed to create only one instance of this class
	 * 
	 * @return
	 */
	public static CashCollector getInstance() {
		if (instance == null) {
			instance = new CashCollector();
		}
		return instance;
	}

	/**
	 * returns user cash from box
	 * 
	 * @return
	 */
	public Map<CashEnum, Integer> getCashFromUserStore() {
		return userCashStore;
	}

	/**
	 * add cash to userCashStore during cash insertion
	 * 
	 * @param item
	 */
	public void addCashToUserStore(CashEnum cash, int count) {
		userCashStore.put(cash, count);
	}

	/**
	 * reset user cash store when user ask for refund or transaction done
	 */
	public void resetUserCashStore() {
		userCashStore.clear();
	}

	/**
	 * find the total amount user paid for the purchase
	 * 
	 * @return
	 */
	public int getTotalPaidAmount() {
		int total = 0;
		if (userCashStore != null) {
			Set<CashEnum> keys = userCashStore.keySet();
			for (CashEnum key : keys) {
				Integer count = userCashStore.get(key);
				if (count != null) {
					int denomaination = key.getValue();
					total = total + (count * denomaination);
				}
			}
		}
		return total;
	}

}
