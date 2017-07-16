package com.vending.controller;

import java.util.Map;

import com.vending.agent.StoreDispenserAgentImpl;
import com.vending.api.CustomerApi;
import com.vending.customer.cart.CashCollector;
import com.vending.customer.cart.SelectedItemsCart;
import com.vending.exception.NotFullPaidException;
import com.vending.exception.NotSufficientChangeException;
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
	StoreDispenserAgentImpl storeAgent = null;

	public CustomerController() {
		selectedCart = SelectedItemsCart.getInstance();
		cashCollector = CashCollector.getInstance();
		storeAgent = new StoreDispenserAgentImpl();
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
	 * 
	 * @throws NotFullPaidException
	 */

	@Override
	public void collectItemAndChange() throws NotFullPaidException, NotSufficientChangeException {

		long purchaseTotal = selectedCart.getPayableAmount();
		long paidTotal = cashCollector.getTotalPaidAmount();

		if (paidTotal >= purchaseTotal) {// paid >= purchase return change if
											// available else return change not
											// available exception
			long changeAmount = paidTotal - purchaseTotal;
			if (storeAgent.hasSufficientChangeForAmount(changeAmount)) {
				// if change available return item and change
			} else {
				// else return exception change not available ask user to
				// purchase
				// something or ask for refund
				throw new NotSufficientChangeException("Not Sufficient change in Inventory");
			}
		} else {// check amount paid is < than
				// payable return exception
			long balance = purchaseTotal - paidTotal;
			throw new NotFullPaidException("Price not full paid, remaining : ", balance);
		}

	}

	/**
	 * allows customer to see the amount for the purchase
	 */
	@Override
	public long viewPaidAmount() {
		return cashCollector.getTotalPaidAmount();
	}

}
