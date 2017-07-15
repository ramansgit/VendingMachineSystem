package com.vending.customer.cart;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.vending.exception.ProductExistException;
import com.vending.model.Item;

/**
 * responsible for managing user selected items in the cart for the transaction
 * 
 * @author ramans
 *
 */
public class SelectedItemsCart {

	public static SelectedItemsCart instance = null;
	/**
	 * selected items for the transaction will be managed in this cart
	 */
	private Map<String, Item> selectedCart = new LinkedHashMap<String, Item>();

	private SelectedItemsCart() {

	}

	/**
	 * singleton pattern followed to create only one instance of this class
	 * 
	 * @return
	 */
	public static SelectedItemsCart getInstance() {
		if (instance == null) {
			instance = new SelectedItemsCart();
		}
		return instance;
	}

	/**
	 * returns selected Items from cart
	 * 
	 * @return
	 */
	public Map<String, Item> getSelectedItemsFromCart() {
		return selectedCart;
	}

	/**
	 * add user selected items to selectionCart
	 * 
	 * @param item
	 */

	public void addItemToSelectionCart(Item item) throws ProductExistException {
		if (item != null) {
			if (item.getProductId() != null && !item.getProductId().isEmpty()) {
				if (!hasProductItem(item.getProductId())) {
					selectedCart.put(item.getProductId(), item);
				} else {
					throw new ProductExistException("Can't add Duplicate products");
				}

			}
		}

	}

	/**
	 * checks whether product exist in the selection cart
	 * 
	 * @param productId
	 * @return
	 */
	public boolean hasProductItem(String productId) {
		if (productId != null && !productId.isEmpty()) {
			return selectedCart.containsKey(productId);
		}
		return false;
	}

	/**
	 * find the total payable amount based on selected item cart
	 * 
	 * @return
	 */
	public int getPayableAmount() {
		int total = 0;
		if (selectedCart != null) {
			Set<String> keys = selectedCart.keySet();
			for (String key : keys) {
				Item it = selectedCart.get(key);
				if (it != null) {
					int qty = it.getQty();
					int price = it.getPrice();
					total = total + (qty * price);
				}
			}
		}
		return total;
	}

}
