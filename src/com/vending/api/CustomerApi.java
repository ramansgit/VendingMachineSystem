package com.vending.api;

import java.util.Map;

import com.vending.exception.NotFullPaidException;
import com.vending.exception.NotSufficientChangeException;
import com.vending.exception.ProductExistException;
import com.vending.model.CashEnum;
import com.vending.model.Item;

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
	public abstract long viewPayableAmount();
	
	
	/**
	 * get paid amount for purchase
	 * 
	 */
	public abstract long viewPaidAmount();

	/**
	 * allows customer to add product item to cart
	 * 
	 * @return
	 */
	public abstract void addSelectedItemsToCart(Item item) throws ProductExistException;

	/**
	 * allows customer to pay for the purchase
	 * 
	 * @return
	 */
	public abstract void insertCashForPurchase(CashEnum denomination,int amount);
	
	
	/** 
	 * allows customer to collect item and change if any for the purchase
	 */
	public abstract void collectItemAndChange() throws NotFullPaidException, NotSufficientChangeException;

	/**
	 * allows customer to cancel purchase and gets refund
	 */
	public abstract Map<CashEnum,Integer> cancelItemsFromCartAndRefund();

}
