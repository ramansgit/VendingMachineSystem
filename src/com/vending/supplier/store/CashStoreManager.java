package com.vending.supplier.store;

import java.util.HashMap;
import java.util.Map;

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
	private Map<CashEnum, Integer> cashFromStore = new HashMap<CashEnum, Integer>();

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
	
	public boolean hasDenomiationInCashStore(CashEnum type){
		if(type !=null){
			
		}
		
		return false;
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
