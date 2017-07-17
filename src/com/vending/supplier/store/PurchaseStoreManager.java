package com.vending.supplier.store;

import java.util.ArrayList;
import java.util.List;

import com.vending.model.Purchase;

/**
 * responsible for managing purchase statement. supplier can view the purchase
 * 
 * @author ramans
 *
 */
public class PurchaseStoreManager {

	public static PurchaseStoreManager instance = null;
	private List<Purchase> purchaseStatement = new ArrayList<Purchase>();

	/**
	 * private constructor
	 */
	private PurchaseStoreManager() {

	}

	/**
	 * singleton pattern followed to create only one instance of this class
	 * 
	 * @return
	 */
	public static PurchaseStoreManager getInstance() {
		if (instance == null) {
			instance = new PurchaseStoreManager();
		}
		return instance;
	}

	/**
	 * returns all purchases
	 * 
	 * @return
	 */
	public List<Purchase> getPurchaseStatement() {
		System.out.println("get purchashe statement");
		return purchaseStatement;
	}

	/**
	 * add purchase to store
	 * 
	 * @param item
	 */
	public void addPurchase(Purchase purchase) {
		purchaseStatement.add(purchase);
	}

	/**
	 * reset purchase summary
	 */
	public void resetPurchaseSummary() {
		purchaseStatement.clear();
	}

}
