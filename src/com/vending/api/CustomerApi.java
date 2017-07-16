package com.vending.api;

import java.util.Map;

import com.vending.exception.NotFullPaidException;
import com.vending.exception.NotSufficientChangeException;
import com.vending.model.CashEnum;
import com.vending.model.DispenseItemAndChange;
import com.vending.model.Item;

/**
 * interaction between customer and system interface are captured here.
 * @author ramans
 *
 */
public interface CustomerApi {

	/**
	 * allows customer to see available products from store
	 * 
	 * @return
	 */
	public abstract Map<String, Item> viewProductItemsFromStore();

	/**
	 * allows customer to view selected items from cart
	 * 
	 * @return
	 */
	public abstract Map<String, Item> viewSelectedItemsFromCart();
	
	/**
	 * get payable amount from selected item cart
	 * 
	 */
	public abstract int viewPayableAmount();
	
	
	/**
	 * get paid amount for purchase
	 * 
	 */
	public abstract int viewPaidAmount();

	/**
	 * allows customer to add product item to cart
	 * 
	 * @return
	 */
	public abstract void addSelectedItemsToCart(Item item);
	
	
	/**
	 * allows customer to update selected product qty
	 * 
	 * @return
	 */
	public abstract void updateSelectedItemQty(String productId,int qty);
	
	/**
	 * allows customer to update selected product price
	 * 
	 * @return
	 */
	public abstract void updateSelectedItemPrice(String productId,int price);
	
	
	/**
	 * allows customer to delete selected product 
	 * 
	 * @return
	 */
	public abstract void removeSelectedItemFromCart(String productId);

	/**
	 * allows customer to pay for the purchase
	 * 
	 * @return
	 */
	public abstract void insertCashForPurchase(CashEnum denomination,int amount);
	
	
	/** 
	 * allows customer to collect item and change if any for the purchase
	 */
	public abstract DispenseItemAndChange collectItemAndChange() throws NotFullPaidException, NotSufficientChangeException;

	/**
	 * allows customer to cancel purchase and gets refund
	 */
	public abstract Map<CashEnum,Integer> cancelItemsFromCartAndRefund();

}
