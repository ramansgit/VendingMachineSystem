package com.vending.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import com.vending.api.CustomerApi;
import com.vending.api.SupplierApi;
import com.vending.controller.SupplierController;
import com.vending.exception.NotFullPaidException;
import com.vending.exception.NotSufficientChangeException;
import com.vending.model.CashEnum;
import com.vending.model.DispenseItemAndChange;
import com.vending.model.Item;

public class TestVendingMachineiInterface {
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

	public void testAddCashWithDenominations(CashEnum cash, int count) {
		supplier.addCashWithDenominations(cash, count);

	}

	public void testViewPurchaseHistory() {
		supplier.viewPurchaseHistory();
		System.out.println("view purchase statement \n");

	}

	public void testResetStore() {
		supplier.resetStore();
		System.out.println("store reset successfully");
	}
	
	
	/**
	 * customer api 
	 * @param args
	 */
	
	
	public Map<String, Item> testViewProductItemsFromStore1() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Item> testViewSelectedItemsFromCart() {
		// TODO Auto-generated method stub
		return null;
	}

	public int testViewPayableAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int testViewPaidAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void testAddSelectedItemsToCart(Item item) {
		// TODO Auto-generated method stub
		
	}

	
	public void testInsertCashForPurchase(CashEnum denomination, int amount) {
	
		
	}

	public DispenseItemAndChange testCollectItemAndChange() throws NotFullPaidException, NotSufficientChangeException {
		
		return null;
	}

	public Map<CashEnum, Integer> testCancelItemsFromCartAndRefund() {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {

		System.out.println("*** Supplier Menu ***");

		System.out.println("Press option 1 for adding products to store");
		System.out.println("Press option 2 for adding cash to store");
		System.out.println("Press option 3 for viewing available products");
		System.out.println("Press option 4 for viewing cash denominations and qty from store");
		System.out.println("Press option 5 for viewing purchase history");
		System.out.println("Press option 6 for reset");
		
		
		System.out.println("*** Customer Menu ***");

		System.out.println("Press option 7 for view product from store");
		System.out.println("Press option 8 for view selected item from cart");
		System.out.println("Press option 9 for viewing available products");
		System.out.println("Press option 10 for viewing cash denominations and qty from store");
		System.out.println("Press option 11 for viewing purchase history");
		System.out.println("Press option 12 for reset");
		System.out.println("Press option 13 for reset");
		System.out.println("Press option 14 for reset");
		
		System.out.println("Press option 13 for stop");
		
		
		System.out.println("Press option 7 for stop");
		

		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.print("Enter your options : ");
				String input = br.readLine();

				TestVendingMachineiInterface test = new TestVendingMachineiInterface();

				if (input != null && input.equals("1")) {
					Set<Item> items = TestReadFromCsvUtil.readProductFromCsv();
					for (Item it : items) {
							test.testAddProductItemToStore(it);
						 
					}
					System.out.println("products added successfully");
				}
				if (input != null && input.equals("2")) {
					Map<CashEnum, Integer> cashItems = TestReadFromCsvUtil.readCashAndDenominationsFromCsv();

					Set<CashEnum> keys = cashItems.keySet();
					for (CashEnum it : keys) {
						try {
							test.testAddCashWithDenominations(it, cashItems.get(it));
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
