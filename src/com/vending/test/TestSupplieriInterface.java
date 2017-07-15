package com.vending.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import com.vending.api.SupplierApi;
import com.vending.controller.SupplierController;
import com.vending.exception.ProductExistException;
import com.vending.model.Cash;
import com.vending.model.Item;
import com.vending.test.util.TestReadFromCsvUtil;
import com.vending.utils.CashEnum;

public class TestSupplieriInterface {
	SupplierApi api = new SupplierController();

	public void testViewProductItemsFromStore() {
		Map<String, Item> items = api.viewProductItemsFromStore();
		System.out.println("available products are \n" + items);
	}

	public void testViewCashDenominationsFromStore() {
		Map<CashEnum, Cash> cash = api.viewCashDenominations();
		System.out.println("available cash denominations are \n" + cash);
	}

	public void testAddProductItemToStore(Item item) throws ProductExistException {
		api.addProductItemToStore(item);

	}

	public void testAddCashWithDenominations(Cash cash) {
		api.addCashWithDenominations(cash);

	}

	public void testViewPurchaseHistory() {
		api.viewPurchaseHistory();
		System.out.println("view purchase statement \n");

	}

	public void testResetStore() {
		api.resetStore();
		System.out.println("store reset successfully");
	}

	public static void main(String[] args) {

		System.out.println("*** Supplier Menu ***");

		System.out.println("Press option 1 for adding products to store");
		System.out.println("Press option 2 for adding cash to store");
		System.out.println("Press option 3 for viewing available products");
		System.out.println("Press option 4 for viewing cash denominations and qty from store");
		System.out.println("Press option 5 for viewing purchase history");
		System.out.println("Press option 6 for reset");
		System.out.println("Press option 7 for stop");

		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.print("Enter your options : ");
				String input = br.readLine();

				TestSupplieriInterface test = new TestSupplieriInterface();

				if (input != null && input.equals("1")) {
					Set<Item> items = TestReadFromCsvUtil.readProductFromCsv();
					for (Item it : items) {
						try {
							test.testAddProductItemToStore(it);
						} catch (ProductExistException e) {
							e.printStackTrace();
						}
					}
					System.out.println("products added successfully");
				}
				if (input != null && input.equals("2")) {
					Set<Cash> cashItems = TestReadFromCsvUtil.readCashAndDenominationsFromCsv();
					for (Cash it : cashItems) {
						try {
							test.testAddCashWithDenominations(it);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					System.out.println("Cash added successfully");
				}
				if (input != null && input.equals("3")) {
					test.testViewProductItemsFromStore();
				}
				if (input != null && input.equals("4")) {
					test.testViewCashDenominationsFromStore();
				}
				if (input != null && input.equals("5")) {
					test.testViewPurchaseHistory();
				}
				if (input != null && input.equals("6")) {
					test.testResetStore();
				}
				if (input != null && input.equals("7")) {
					System.out.println("Exit!");
					System.exit(0);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
