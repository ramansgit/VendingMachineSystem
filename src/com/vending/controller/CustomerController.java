package com.vending.controller;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import com.vending.agent.DispenserApiImpl;
import com.vending.api.CustomerApi;
import com.vending.customer.cart.CashCollector;
import com.vending.customer.cart.SelectedItemsCart;
import com.vending.exception.NotFullPaidException;
import com.vending.exception.NotSufficientChangeException;
import com.vending.model.CashEnum;
import com.vending.model.DispenseItemAndChange;
import com.vending.model.Item;
import com.vending.model.Purchase;

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
	DispenserApiImpl storeAgent = null;

	public CustomerController() {
		selectedCart = SelectedItemsCart.getInstance();
		cashCollector = CashCollector.getInstance();
		storeAgent = new DispenserApiImpl();
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
	public int viewPayableAmount() {
		return selectedCart.getPayableAmount();
	}

	/**
	 * allows user to add items to selection cart
	 */
	@Override
	public void addSelectedItemsToCart(Item item) {
		selectedCart.addItemToSelectionCart(item);

	}

	/**
	 * allows user to pay for the purchase
	 */
	@Override
	public void insertCashForPurchase(CashEnum denomination, int count) {
		cashCollector.addCashToUserStore(denomination, count);
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
		Map<CashEnum, Integer> refund = new TreeMap<CashEnum, Integer>(Collections.reverseOrder());
		
		refund.putAll(userCashStore);
	
		// reset user cash store
		cashCollector.resetUserCashStore();
		
		System.out.println(refund);
		return refund;

	}

	/**
	 * when user confirms to complete the purchase this will be invoked
	 * 
	 * @throws NotFullPaidException
	 */

	@Override
	public DispenseItemAndChange confirmPurchase() throws NotFullPaidException, NotSufficientChangeException {

		int purchaseTotal = selectedCart.getPayableAmount();
		int paidTotal = cashCollector.getTotalPaidAmount();
		Map<String, Item> dispenseItem = null;
		Map<CashEnum, Integer> dispenseChange = null;
		DispenseItemAndChange dispense = null;
		Purchase statement = new Purchase();
		if (paidTotal >= purchaseTotal) {// paid >= purchase return change if
											// available else return change not
											// available exception
			int changeAmount = paidTotal - purchaseTotal;
			if (storeAgent.hasSufficientChangeForAmount(changeAmount)) {
				// if change available return item and change
				dispenseItem = storeAgent.dispenseItemsFromStore(selectedCart.getSelectedItemsFromCart());
				dispenseChange = storeAgent.dispenseChangeFromStore(changeAmount);
				storeAgent.dispenseUserCashToStore(cashCollector.getCashFromUserStore());
				// capture purchase summary
				statement.setCreateDate(new Date());
				statement.setTotalAmout(selectedCart.getPayableAmount());
				statement.setPurchasedItems(selectedCart.getSelectedItemsFromCart());
				statement.setTransactionId(UUID.randomUUID().toString());
				storeAgent.addPurchaseSummaryToStore(statement);
				dispense = new DispenseItemAndChange(dispenseChange, dispenseItem);

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

		return dispense;
	}

	/**
	 * allows customer to see the amount for the purchase
	 */
	@Override
	public int viewPaidAmount() {
		return cashCollector.getTotalPaidAmount();
	}



	/**
	 * allows customer to update qty for an item in the selectioncart
	 */
	@Override
	public void updateSelectedItemQty(String productId, int qty) {
		if (productId != null && !productId.isEmpty()) {
			if (selectedCart.hasProductItem(productId)) {
				System.out.println("updating product qty");
				Item it = selectedCart.getProduct(productId);
				if (it != null) {
					it.setQty(qty);
					selectedCart.getSelectedItemsFromCart().put(productId, it);
				}
			}

		}


	}

	/**
	 * removes an item from the selected item cart store
	 */
	@Override
	public void removeSelectedItemFromCart(String productId) {
		if (productId != null && !productId.isEmpty()) {
			for (Iterator<Map.Entry<String, Item>> it = selectedCart.getSelectedItemsFromCart().entrySet()
					.iterator(); it.hasNext();) {
				Map.Entry<String, Item> entry = it.next();
				if (entry.getKey().equalsIgnoreCase(productId)) {
					it.remove();
				}
			}
		}

	}

}
