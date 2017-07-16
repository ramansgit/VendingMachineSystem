package com.vending.supplier.store;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.vending.model.CashEnum;

/**
 * CashStoreManager to manage cash in the system
 * 
 * @author ramans
 * @param <CashEnum>
 *
 */
public class CashStoreManager {

	public static CashStoreManager instance = null;
	private Map<CashEnum, Integer> cashFromStore = new TreeMap<CashEnum, Integer>(Collections.reverseOrder());

	private CashStoreManager() {

	}

	/**
	 * singleton pattern followed to create only one instance of this class
	 * 
	 * @return
	 */
	public static CashStoreManager getInstance() {
		if (instance == null) {
			instance = new CashStoreManager();
		}
		return instance;
	}

	/**
	 * returns available cash with denominations
	 * 
	 * @return
	 */
	public Map<CashEnum, Integer> getCashFromStore() {
		return cashFromStore;
	}

	/**
	 * add cash and denominations to store
	 * 
	 * @param item
	 */
	public void addCashToStore(CashEnum cash,int count) {

		if (cash != null) {
			cashFromStore.put(cash, count);
		}

	}
	
	/**
	 * update cash and denominations to store ** when change is returned or when user cash transfered to store
	 * 
	 * @param item
	 */
	public void updateCashInStore(CashEnum cash,int count) {
		if (cash != null) {
			cashFromStore.put(cash, count);
		}

	}


	/**
	 * reset cash store
	 */
	public void resetCash() {
		cashFromStore.clear();
	}
	
	
	public static void main(String[] args) {
		CashEnum[] valu = CashEnum.values();
		for (CashEnum cas : valu) {
			System.out.println(cas);
		}
	}
}
