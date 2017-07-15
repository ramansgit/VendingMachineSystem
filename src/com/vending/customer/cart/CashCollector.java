package com.vending.customer.cart;

import java.util.ArrayList;
import java.util.List;

import com.vending.model.Cash;
import com.vending.utils.CashEnum;

/**
 * class responsible for managing user cash for the transaction.
 * 
 * @author ramans
 *
 */
public class CashCollector {

	public static CashCollector instance = null;
	/**
	 * collects user cash for the transaction
	 */
	private List<Cash> userCashBox = new ArrayList<Cash>();

	private CashCollector() {

	}

	/**
	 * singleton pattern followed to create only one instance of this class
	 * 
	 * @return
	 */
	public static CashCollector getInstance() {
		if (instance == null) {
			instance = new CashCollector();
		}
		return instance;
	}

	/**
	 * returns user cash from box
	 * 
	 * @return
	 */
	public List<Cash> getCashFromUserBox() {
		return userCashBox;
	}

	/**
	 * add cash to userbox during cash insertion
	 * 
	 * @param item
	 */
	public void addCashToUserBox(Cash cash) {
		userCashBox.add(cash);
	}

	/**
	 * process user cash in cash collector
	 * 
	 * @param denomination
	 * @param amountPaid
	 */
	public void processUserCash(CashEnum denomination, int amountPaid) {
		int totalPayable = SelectedItemsCart.getInstance().getPayableAmount();
		if (amountPaid == totalPayable) {
			// take user confirmation and dispense item
		}
		if (amountPaid < totalPayable) {
			// add paid to user cash box
			// find balance and ask for more cash
		}
		if (amountPaid > totalPayable) {
			// find balance and check denomination available in cash store
			// if yes add cash to user cash box
			// return balance
			// if no ask user to user to pay other denominations
		}
	}

	

}
