package com.vending.api;

import java.util.List;
import java.util.Map;

import com.vending.model.CashEnum;
import com.vending.model.Item;
import com.vending.model.Purchase;

/**
 * interaction between supplier and system are captured here.
 * @author ramans
 *
 */
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
	public abstract void addProductItemToStore(Item item);
	
	/**
	 * allows supplier to update product price
	 * @param item
	 */
	public abstract void updateProductPrice(String productId,int price);
	
	/**
	 * allows supplier to update product qty
	 * @param item
	 */
	public abstract void updateProductQty(String productId,int qty);
	
	
	/**
	 * allows supplier to add denominations to the case store
	 */
	public abstract void addCashDenominations(CashEnum casg,int count);
	
	
	/** 
	 * allows supplier to view denominations and qty from cash store
	 */
	
	public abstract Map<CashEnum,Integer> viewCashDenominations();
	
	/**
	 * allows supplier to view all purchase history 
	 */
	public abstract List<Purchase> viewPurchaseHistory();
	/**
	 * allows supplier to reset items, cash and purchase history from store
	 */
	public abstract void resetStore();
	
	/**
	 * allows supplier to remove an item from the store
	 * @param productId
	 */
	public abstract void removeItemFromStore(String productId);
}
