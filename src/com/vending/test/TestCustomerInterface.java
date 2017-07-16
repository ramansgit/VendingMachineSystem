package com.vending.test;

import java.util.Map;

import com.vending.api.CustomerApi;
import com.vending.controller.CustomerController;
import com.vending.exception.NotFullPaidException;
import com.vending.exception.NotSufficientChangeException;
import com.vending.model.CashEnum;
import com.vending.model.DispenseItemAndChange;
import com.vending.model.Item;

public class TestCustomerInterface {

	CustomerApi customer = new CustomerController();

	public Map<String, Item> viewProductItemsFromStore() {

		return customer.viewProductItemsFromStore();
	}

	public Map<String, Item> viewSelectedItemsFromCart() {
		return customer.viewSelectedItemsFromCart();

	}

	public int viewPayableAmount() {

		return customer.viewPayableAmount();
	}

	public int viewPaidAmount() {

		return customer.viewPaidAmount();
	}

	public void addSelectedItemsToCart(Item item) {

		customer.addSelectedItemsToCart(item);

	}

	public void updateSelectedItemQty(String productId, int qty) {
		customer.updateSelectedItemQty(productId, qty);

	}

	public void removeSelectedItemFromCart(String productId) {

		customer.removeSelectedItemFromCart(productId);

	}

	public void insertCashForPurchase(CashEnum denomination, int amount) {

		customer.insertCashForPurchase(denomination, amount);

	}

	public Map<CashEnum, Integer> cancelItemsFromCartAndRefund() {
		return customer.cancelItemsFromCartAndRefund();
	}

	public DispenseItemAndChange confirmPurchase() throws NotFullPaidException, NotSufficientChangeException {

		return customer.confirmPurchase();
	}

	public void invokeCustomerTest(String val) {

		Integer value = Integer.parseInt(val);
		if (value == 10) {
			System.out.println("Available products from store \n" + viewProductItemsFromStore());
		}
		if (value == 11) {
			System.out.println("Selected products from cart \n" + viewSelectedItemsFromCart());
		}
		if (value == 12) {
			System.out.println("view customer payable total amount \n" + viewPayableAmount());
		}
		if (value == 13) {
			System.out.println("view customer paid amount for the purchase \n" + viewPaidAmount());
		}
		if (value == 14) {
			System.out.println("add items to selection cart \n");
			addSelectedItemsToCart(new Item("AA", "COKE", 45, 1));
			addSelectedItemsToCart(new Item("AB", "PEPSI", 40, 3));
			addSelectedItemsToCart(new Item("AC", "MAAZA", 15, 5));

			System.out.println("products added to selection cart \n");
		}
		if (value == 15) {
			System.out.println("update qty in selection cart \n");
			updateSelectedItemQty("AA", 4);
			System.out.println("updated qty in cart\n");
		}
		if (value == 16) {
			System.out.println("remove item from selection cart \n");
			removeSelectedItemFromCart("AB");
			System.out.println("removed product from cart\n");
		}
		if (value == 17) {
			insertCashForPurchase(CashEnum.FIFTY, 5);
			insertCashForPurchase(CashEnum.TEN, 10);
			insertCashForPurchase(CashEnum.FIVE, 2);
		}
		if (value == 18) {
			System.out.println("cancelling transaction and taking refund \n");
			System.out.println("refunded amount " + cancelItemsFromCartAndRefund());
		}
		if (value == 19) {
			System.out.println("confirm for purchase ** once confimred can't be changed ");
			try {
				System.out.println("response for purchase " + confirmPurchase());
			} catch (NotFullPaidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotSufficientChangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
