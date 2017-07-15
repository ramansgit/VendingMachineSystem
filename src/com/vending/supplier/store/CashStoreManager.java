package com.vending.supplier.store;

import java.util.LinkedHashMap;
import java.util.Map;

import com.vending.model.Cash;
import com.vending.utils.CashEnum;

/**
 * CashStoreManager to manage cash in the system
 * 
 * @author ramans
 * @param <CashEnum>
 *
 */
public class CashStoreManager {

	public static CashStoreManager instance = null;
	private Map<CashEnum, Cash> cashFromStore = new LinkedHashMap<CashEnum, Cash>();

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
	public Map<CashEnum, Cash> getCashFromStore() {
		return cashFromStore;
	}

	/**
	 * add cash and denominations to store
	 * 
	 * @param item
	 */
	public void addCashToStore(Cash cash) {

		if (cash != null && cash.getDenominations() != null) {
			cashFromStore.put(cash.getDenominations(), cash);
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
