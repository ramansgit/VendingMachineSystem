package com.vending.controller;

import java.util.Map;

import com.vending.api.SupplierApi;
import com.vending.exception.ProductExistException;
import com.vending.model.CashEnum;
import com.vending.model.Item;
import com.vending.supplier.store.CashStoreManager;
import com.vending.supplier.store.ProductStoreManager;
import com.vending.supplier.store.PurchaseStoreManager;

/**
 * supplier is responsible for, loads products into product store loads cash
 * with denomination into cash store views purchase history resets stocks from
 * the system.
 * 
 * @author ramans
 *
 */
public class SupplierController implements SupplierApi {

	/**
	 * creates instance of productStore Manager
	 */
	ProductStoreManager itemManger = null;

	/**
	 * creates instance for cash manager
	 */
	CashStoreManager cashManager = null;

	/**
	 * creates instance for purchase manager
	 */
	PurchaseStoreManager purchaseStatement = null;

	public SupplierController() {
		itemManger = ProductStoreManager.getInstance();
		cashManager = CashStoreManager.getInstance();
		purchaseStatement = PurchaseStoreManager.getInstance();
	}

	/**
	 * view's all available products
	 */
	@Override
	public Map<String, Item> viewProductItemsFromStore() {
		return itemManger.getItemsFromStore();
	}

	/**
	 * add product to the store
	 * @throws ProductExistException 
	 */
	@Override
	public void addProductItemToStore(Item item) throws ProductExistException {
		itemManger.addItemToStore(item);
	}

	/**
	 * add cash to the system with denominations
	 */
	@Override
	public void addCashWithDenominations(CashEnum cash,int count)  {
		cashManager.addCashToStore(cash,count);
	}

	/**
	 * view purchase history
	 */

	@Override
	public void viewPurchaseHistory() {
		purchaseStatement.getPurchaseStatement();
	}

	/**
	 * reset's purchase, product's and cash from the store
	 */
	@Override
	public void resetStore() {
		itemManger.resetStore();
		cashManager.resetCash();
		purchaseStatement.resetPurchaseSummary();
	}

	/**
	 * view cash denominations from cash store
	 */

	@Override
	public Map<CashEnum, Integer> viewCashDenominations() {
		return cashManager.getCashFromStore();
	}

}
