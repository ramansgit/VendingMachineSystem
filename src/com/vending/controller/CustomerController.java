package com.vending.controller;

import java.util.Map;

import com.vending.api.CustomerApi;
import com.vending.customer.cart.CashCollector;
import com.vending.customer.cart.SelectedItemsCart;
import com.vending.exception.ProductExistException;
import com.vending.model.Item;
import com.vending.supplier.store.ProductStoreManager;
import com.vending.utils.CashEnum;

/**
 * allows customer to perform actions, view products add products to cart add
 * cash for purchase cancel purchase
 * 
 * @author ramans
 *
 */
public class CustomerController implements CustomerApi {

	/**
	 * creates instance of productStore Manager
	 */
	ProductStoreManager itemManger = null;
	SelectedItemsCart selectedCart = null;
	CashCollector cashCollector = null;

	public CustomerController() {
		itemManger = ProductStoreManager.getInstance();
		selectedCart = SelectedItemsCart.getInstance();
		cashCollector = CashCollector.getInstance();
	}

	/**
	 * allows customer to view available products from the store
	 */
	@Override
	public Map<String, Item> viewProductItemsFromStore() {
		return itemManger.getItemsFromStore();
	}

	/**
	 * allows user to see the selected items from cart
	 */
	@Override
	public Map<String, Item> viewSelectedItemsFromCart() {
		return selectedCart.getSelectedItemsFromCart();
	}

	@Override
	public int viewPayableAmount() {
		return selectedCart.getPayableAmount();
	}

	/**
	 * allows user to add items to selection cart
	 */
	@Override
	public void addSelectedItemsToCart(Item item) throws ProductExistException {
		selectedCart.addItemToSelectionCart(item);

	}

	/**
	 * allows user to pay for the purchase
	 */
	@Override
	public void collectCashForPurchase(CashEnum denomination, int amountPaid) {
		cashCollector.processUserCash(denomination, amountPaid);
	}

	/**
	 * allows user to cancel purchase and get refund if applicable
	 */
	@Override
	public void cancelItemsFromCartAndRefund() {

		
		
	}

}
