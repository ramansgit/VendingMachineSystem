package com.vending.agent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vending.exception.NotSufficientChangeException;
import com.vending.model.CashEnum;
import com.vending.model.Item;
import com.vending.model.Purchase;
import com.vending.supplier.store.CashStoreManager;
import com.vending.supplier.store.ProductStoreManager;
import com.vending.supplier.store.PurchaseStoreManager;

/**
 * This agent acts as middleman between consumer store and supplier store.
 * transfers user cash to supplier store, returns change from supplier cash
 * store to consumer allows consumer to view supplier store products returns
 * item from supplier store to consumer writes purchase summary to supplier
 * purchase store
 * 
 * @author ramans
 */
public class StoreDispenserAgentImpl implements StoreDispenserAgent {

	CashStoreManager cashManager = null;
	ProductStoreManager productManager = null;
	PurchaseStoreManager purchaseManager = null;

	public StoreDispenserAgentImpl() {
		cashManager = CashStoreManager.getInstance();
		productManager = ProductStoreManager.getInstance();
		purchaseManager = PurchaseStoreManager.getInstance();
	}

	/**
	 * consumer can view products via viewProductItemsFromStore
	 */
	@Override
	public Map<String, Item> viewProductItemsFromStore() {
		return productManager.getItemsFromStore();
	}

	@Override
	public void dispenseItemsFromStore(Map<String, Item> selectedCartItems) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<CashEnum, Integer> dispenseChangeFromStore(long changeAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPurchaseSummaryToStore(Purchase statement) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<CashEnum, Integer> dispenseUserCashToStore(Map<CashEnum, Integer> usercash) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * returns true if sufficient change found, otherwise returns false when
	 * change not found
	 */
	@Override
	public boolean hasSufficientChangeForAmount(long changeAmount) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) throws NotSufficientChangeException {

		StoreDispenserAgentImpl store = new StoreDispenserAgentImpl();
		List<CashEnum> changes = store.getChange(75);
		System.out.println(changes);
	}

	public Map<CashEnum, Integer> getCashStore() {
		Map<CashEnum, Integer> map = new HashMap<>();
		map.put(CashEnum.ONE, 5);
		map.put(CashEnum.TWO, 2);
		map.put(CashEnum.FIVE, 0);
		map.put(CashEnum.TEN, 1);
		map.put(CashEnum.TWENTY, 1);
		map.put(CashEnum.FIFTY, 2);
		map.put(CashEnum.HUNDRED, 9);
		map.put(CashEnum.FIVEHUNDRED, 1);
		map.put(CashEnum.TWOTHOUSAND, 0);
		return map;
	}

	private List<CashEnum> getChange(long amount) throws NotSufficientChangeException {
		
		
		List<CashEnum> changes = Collections.EMPTY_LIST;
		Map<CashEnum, Integer> cashStore = getCashStore();

		if (amount > 0) {
			changes = new ArrayList<CashEnum>();
			long balance = amount;
			while (balance > 0) {
				System.out.println("hello");
				if (balance >= CashEnum.ONE.getValue() && cashStore.get(CashEnum.ONE) > 0) {
					changes.add(CashEnum.ONE);
					cashStore.put(CashEnum.ONE, (int) cashStore.get(CashEnum.ONE) - 1);
					balance = balance - CashEnum.ONE.getValue();
					continue;

				} else if (balance >= CashEnum.TWO.getValue() && cashStore.get(CashEnum.TWO) > 0) {
					changes.add(CashEnum.TWO);
					cashStore.put(CashEnum.TWO, (int) cashStore.get(CashEnum.TWO) - 1);
					balance = balance - CashEnum.TWO.getValue();
					continue;

				} else if (balance >= CashEnum.FIVE.getValue() && cashStore.get(CashEnum.FIVE) > 0) {
					changes.add(CashEnum.FIVE);
					cashStore.put(CashEnum.FIVE, (int) cashStore.get(CashEnum.FIVE) - 1);
					balance = balance - CashEnum.FIVE.getValue();
					continue;

				} else if (balance >= CashEnum.TEN.getValue() && cashStore.get(CashEnum.TEN) > 0) {
					changes.add(CashEnum.TEN);
					cashStore.put(CashEnum.TEN, (int) cashStore.get(CashEnum.TEN) - 1);
					balance = balance - CashEnum.TEN.getValue();
					continue;

				} else if (balance >= CashEnum.TWENTY.getValue() && cashStore.get(CashEnum.TWENTY) > 0) {
					changes.add(CashEnum.TWENTY);
					cashStore.put(CashEnum.TWENTY, (int) cashStore.get(CashEnum.TWENTY) - 1);
					balance = balance - CashEnum.TWENTY.getValue();
					continue;

				} else if (balance >= CashEnum.FIFTY.getValue() && cashStore.get(CashEnum.FIFTY) > 0) {
					changes.add(CashEnum.FIFTY);
					cashStore.put(CashEnum.FIFTY, (int) cashStore.get(CashEnum.FIFTY) - 1);
					balance = balance - CashEnum.FIFTY.getValue();
					continue;

				} else if (balance >= CashEnum.HUNDRED.getValue() && cashStore.get(CashEnum.HUNDRED) > 0) {
					changes.add(CashEnum.HUNDRED);
					cashStore.put(CashEnum.HUNDRED, (int) cashStore.get(CashEnum.HUNDRED) - 1);
					balance = balance - CashEnum.HUNDRED.getValue();
					continue;

				} else if (balance >= CashEnum.FIVEHUNDRED.getValue() && cashStore.get(CashEnum.FIVEHUNDRED) > 0) {
					changes.add(CashEnum.FIVEHUNDRED);
					cashStore.put(CashEnum.FIVEHUNDRED, (int) cashStore.get(CashEnum.FIVEHUNDRED) - 1);
					balance = balance - CashEnum.FIVEHUNDRED.getValue();
					continue;

				} else if (balance >= CashEnum.TWOTHOUSAND.getValue() && cashStore.get(CashEnum.TWOTHOUSAND) > 0) {
					changes.add(CashEnum.TWOTHOUSAND);
					cashStore.put(CashEnum.TWOTHOUSAND, (int) cashStore.get(CashEnum.TWOTHOUSAND) - 1);
					balance = balance - CashEnum.TWOTHOUSAND.getValue();
					continue;

				}

				else {
					System.out.println(cashStore);
					throw new NotSufficientChangeException("NotSufficientChange,Please try another product");
				}
			}
		}

		System.out.println(changes);
		return changes;
	}

}
