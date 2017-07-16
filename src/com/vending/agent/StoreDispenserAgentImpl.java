package com.vending.agent;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.vending.exception.NotSufficientChangeException;
import com.vending.model.CashEnum;
import com.vending.model.Item;
import com.vending.model.Purchase;
import com.vending.supplier.store.CashStoreManager;
import com.vending.supplier.store.ProductStoreManager;
import com.vending.supplier.store.PurchaseStoreManager;
import com.vending.test.TestChangeReturnAlgorithm;

/**
 * This agent acts as middle man between consumer store and supplier store.
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

	/**
	 * consumer selected items will be collected from items store and will be
	 * returned to consumer
	 */
	@Override
	public Map<String, Item> dispenseItemsFromStore(Map<String, Item> selectedCartItems) {
		Map<String, Item> dispenseItems = new LinkedHashMap<String, Item>();

		if (selectedCartItems != null) {
			Set<String> keys = selectedCartItems.keySet();
			for (String productId : keys) {
				if (productId != null && !productId.isEmpty()) {
					dispenseItems.put(productId, productManager.getItemsFromStore().get(productId));
				}
			}
		}

		return dispenseItems;

	}

	/**
	 * adds purchase summary to purchase store
	 */
	@Override
	public void addPurchaseSummaryToStore(Purchase statement) {
		if (statement != null) {
			purchaseManager.addPurchase(statement);
		}
	}

	/**
	 * returns changes from cash store to consumer. in the process updates the
	 * change in cash store
	 * 
	 * @throws NotSufficientChangeException
	 */
	@Override
	public Map<CashEnum, Integer> dispenseChangeFromStore(int changeAmount) throws NotSufficientChangeException {
		Map<CashEnum, Integer> changeDenomiations = new TreeMap<>(Collections.reverseOrder());

		int balance = changeAmount;

		Map<CashEnum, Integer> cashStore = cashManager.getCashFromStore();

		int count = 0;
		Set<CashEnum> keys = cashStore.keySet();
		for (CashEnum key : keys) {
			if (balance >= key.getValue()) {
				count = cashStore.get(key);
				balance = new TestChangeReturnAlgorithm().getBalance(cashStore, changeDenomiations, key, balance, count);
			}
		}
		if (balance > 0) {
			throw new NotSufficientChangeException("NotSufficientChange,Please try another product");
		}
		System.out.println(cashStore);
		System.out.println(changeDenomiations);

		// updates cash store once change returned
		Set<CashEnum> uKeys = cashStore.keySet();
		for (CashEnum key1 : uKeys) {
			cashManager.updateCashInStore(key1, cashStore.get(key1));
		}

		return changeDenomiations;
	}

	/**
	 * dispense user cash from user store to cash store
	 */
	@Override
	public void dispenseUserCashToStore(Map<CashEnum, Integer> usercash) {
		if (usercash != null) {
			Set<CashEnum> uKeys = usercash.keySet();
			for (CashEnum key1 : uKeys) {
				try {
					Integer val1 = cashManager.getCashFromStore().get(key1);
					Integer val2 = usercash.get(key1);
					if (val1 != null && val2 != null) {
						cashManager.updateCashInStore(key1, val1 + val2);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * returns true if sufficient change found, otherwise returns false when
	 * change not found
	 */
	@Override
	public boolean hasSufficientChangeForAmount(int changeAmount) {
		try {
			int balance = changeAmount;
			Map<CashEnum, Integer> cashStore = cashManager.getCashFromStore();
			Map<CashEnum, Integer> changeDenomiations = new TreeMap<>(Collections.reverseOrder());
			int count = 0;
			Set<CashEnum> keys = cashStore.keySet();
			for (CashEnum key : keys) {
				if (balance >= key.getValue()) {
					count = cashStore.get(key);
					balance = findChange(cashStore, changeDenomiations, key, balance, count);
				}
			}
			if (balance > 0) {
				throw new NotSufficientChangeException("NotSufficientChange,Please try another product");
			}
			System.out.println(cashStore);
			System.out.println(changeDenomiations);

		} catch (NotSufficientChangeException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * find the balance
	 * @param cash
	 * @param changeDenomiations
	 * @param type
	 * @param balance
	 * @param count
	 * @return
	 */
	public int findChange(Map<CashEnum, Integer> cash,Map<CashEnum, Integer> changeDenomiations, CashEnum type, int balance, int count) {
		// 0, 1,2 ,3 ,4 ,5
		int denomination = type.getValue();
		int div = balance / denomination; // 1,2,3,4,5...
		if (count == 0) {
			return balance;
		}
		if (div >= count) {
			balance = balance - (denomination * count);
			changeDenomiations.put(type, count);
			count = 0;
			cash.put(type, count);
			
			return balance;
		} else {
			balance = balance - (denomination * div);
			count = count - div;
			cash.put(type, count);
			changeDenomiations.put(type, div);
			return balance;
		}
	}
}
