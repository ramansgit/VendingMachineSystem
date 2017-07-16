package com.vending.test;

import java.util.Map;
import java.util.Set;

import com.vending.api.SupplierApi;
import com.vending.controller.SupplierController;
import com.vending.model.CashEnum;
import com.vending.model.Item;

public class TestSupplierInterface {

	SupplierApi supplier = new SupplierController();

	public void testViewProductItemsFromStore() {
		Map<String, Item> items = supplier.viewProductItemsFromStore();
		System.out.println("available products are \n" + items);
	}

	public void testViewCashDenominationsFromStore() {
		Map<CashEnum, Integer> cash = supplier.viewCashDenominations();
		System.out.println("available cash denominations are \n" + cash);
	}

	public void testAddProductItemToStore(Item item) {
		supplier.addProductItemToStore(item);

	}

	public void testAddCashDenominations(CashEnum cash, int count) {
		supplier.addCashDenominations(cash, count);

	}

	public void testViewPurchaseHistory() {
		supplier.viewPurchaseHistory();
		System.out.println("view purchase statement \n");

	}

	public void testResetStore() {
		supplier.resetStore();
		System.out.println("store reset successfully");
	}

	public void updateProductPrice(String productId, int price) {
		supplier.updateProductPrice(productId, price);

	}

	public void updateProductQty(String productId, int qty) {
		supplier.updateProductPrice(productId, qty);

	}

	public void viewPurchaseHistory() {
		supplier.viewPurchaseHistory();

	}

	public void removeItemFromStore(String productId) {
		supplier.removeItemFromStore(productId);

	}

	public void testSupplierInterface(String val) {
		Integer input = Integer.parseInt(val);
		TestSupplierInterface test = new TestSupplierInterface();
		if (input == 1) {
			Set<Item> items = TestReadFromCsvUtil.readProductFromCsv();
			for (Item it : items) {
				test.testAddProductItemToStore(it);

			}
			System.out.println("products added successfully");
		}
		if (input == 2) {
			Map<CashEnum, Integer> cashItems = TestReadFromCsvUtil.readCashAndDenominationsFromCsv();

			Set<CashEnum> keys = cashItems.keySet();
			for (CashEnum it : keys) {
				try {
					test.testAddCashDenominations(it, cashItems.get(it));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Cash added successfully");
		}
		if (input == 3) {
			test.testViewProductItemsFromStore();
		}
		if (input == 4) {
			test.testViewCashDenominationsFromStore();
		}
		if (input == 5) {
			test.testViewPurchaseHistory();
		}
		if (input == 6) {
			test.testResetStore();
		}
		if (input == 7) {
			updateProductPrice("AA", 79);
			System.out.println("product price updated successfully for AA");
		}
		if (input == 8) {
			updateProductQty("AA", 8);
			System.out.println("product qty updated successfully for AA");
		}

		if (input == 9) {
			removeItemFromStore("AA");
			System.out.println("product AA removed successfully");
		}
		

	}

}
