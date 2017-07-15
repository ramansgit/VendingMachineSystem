package com.vending.api;

import java.util.Map;

import com.vending.exception.ProductExistException;
import com.vending.model.Item;
import com.vending.utils.CashEnum;

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
	public abstract void collectCashForPurchase(CashEnum denomination,int amount);

	/**
	 * allows customer to cancel purchase and gets refund
	 */
	public abstract void cancelItemsFromCartAndRefund();

}
