package com.vending.controller;

import java.util.Map;

import com.vending.agent.StoreAgentImpl;
import com.vending.api.CustomerApi;
import com.vending.customer.cart.CashCollector;
import com.vending.customer.cart.SelectedItemsCart;
import com.vending.exception.ProductExistException;
import com.vending.model.CashEnum;
import com.vending.model.Item;

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
	SelectedItemsCart selectedCart = null;
	CashCollector cashCollector = null;
	StoreAgentImpl storeAgent = null;

	public CustomerController() {
		selectedCart = SelectedItemsCart.getInstance();
		cashCollector = CashCollector.getInstance();
		storeAgent = new StoreAgentImpl();
	}

	/**
	 * allows customer to view available products from the store
	 */
	@Override
	public Map<String, Item> viewProductItemsFromStore() {
		return storeAgent.viewProductItemsFromStore();
	}

	/**
	 * allows user to see the selected items from cart
	 */
	@Override
	public Map<String, Item> viewSelectedItemsFromCart() {
		return selectedCart.getSelectedItemsFromCart();
	}

	@Override
	public long viewPayableAmount() {
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
	public void insertCashForPurchase(CashEnum denomination, int amountPaid) {
		cashCollector.addCashToUserStore(denomination, amountPaid);
	}

	/**
	 * allows user to cancel purchase and get refund if applicable
	 */
	@Override
	public Map<CashEnum, Integer> cancelItemsFromCartAndRefund() {
		// reset selection cart
		selectedCart.resetSelectionCart();
		// refund user cash store
		Map<CashEnum, Integer> userCashStore = cashCollector.getCashFromUserStore();
		// reset user cash store
		cashCollector.resetUserCashStore();
		return userCashStore;

	}

	/**
	 * when user confirms to complete the purchase this will be invoked
	 */

	@Override
	public void collectItemAndChange() {

		// check amount paid is < than payable return exception
		long total = selectedCart.getPayableAmount();

		// if amount paid == payable return item and invoke dispenser for

		// if amount paid > payable then check change
		// if change available return item and change

		// else return exception change not available ask user to purchase
		// something or ask for refund

	}

}
