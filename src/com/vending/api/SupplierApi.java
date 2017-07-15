package com.vending.api;

import java.util.Map;

import com.vending.exception.ProductExistException;
import com.vending.model.Cash;
import com.vending.model.Item;
import com.vending.utils.CashEnum;

public interface SupplierApi {
	
	/**
	 * allows supplier to view product items from store
	 * @return
	 */
	public abstract Map<String,Item> viewProductItemsFromStore();
	
	/**
	 * allows supplier to add product to the item store
	 * @param item
	 */
	public abstract void addProductItemToStore(Item item) throws ProductExistException;
	
	
	/**
	 * allows supplier to add denominations to the case store
	 */
	public abstract void addCashWithDenominations(Cash cash);
	
	
	/** 
	 * allows supplier to view denominations and qty from cash store
	 */
	
	public abstract Map<CashEnum,Cash> viewCashDenominations();
	
	/**
	 * allows supplier to view all purchase history 
	 */
	public abstract void viewPurchaseHistory();
	/**
	 * allows supplier to reset items, cash and purchase history from store
	 */
	public abstract void resetStore();
}
