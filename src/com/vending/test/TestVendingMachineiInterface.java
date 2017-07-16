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

	public static void main(String[] args) {
		System.out.println("*** Supplier Menu ***");

		System.out.println("Press option 1 for adding products to store");
		System.out.println("Press option 2 for adding cash to store");
		System.out.println("Press option 3 for viewing available products");
		System.out.println("Press option 4 for viewing cash denominations and qty from store");
		System.out.println("Press option 5 for viewing purchase history");
		System.out.println("Press option 6 for reset");
		System.out.println("Press option 7 for updating product price in store");
		System.out.println("Press option 8 for updating product qty in store");
		System.out.println("Press option 9 for removing product from store");

		System.out.println("*** Customer Menu ***");

		System.out.println("Press option 10 to view available products from store");
		System.out.println("Press option 11 to view customer selected products from cart");
		System.out.println("Press option 12 to view customer payable total ");
		System.out.println("Press option 13 to view customer paid amount for the purchase");
		System.out.println("Press option 14 for customer to add items to selection cart");
		System.out.println("Press option 15 to update product qty for an item");
		System.out.println("Press option 16 to remove an item from selection cart");
		System.out.println("Press option 17 to insert cash for purchase");
		System.out.println("Press option 18 to cancel selection and get refund ");
		System.out.println("Press option 19 to confirm confirmorder ");
		System.out.println("Press option 20 for stop");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("Enter your options : ");
				String input = br.readLine();
				if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= 9) {
					TestSupplierInterface supplier = new TestSupplierInterface();
					supplier.testSupplierInterface(input);
				}

				if (Integer.parseInt(input) >= 10 && Integer.parseInt(input) <= 19) {
					TestCustomerInterface customer = new TestCustomerInterface();
					customer.invokeCustomerTest(input);
				}
				if (Integer.parseInt(input) == 20) {
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
