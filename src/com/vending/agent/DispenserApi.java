package com.vending.agent;

import java.util.Map;

import com.vending.exception.NotSufficientChangeException;
import com.vending.model.CashEnum;
import com.vending.model.Item;
import com.vending.model.Purchase;

/**
 * This agent acts as middleman between consumer store and supplier store.
 * transfers user cash to supplier store, returns change from supplier cash
 * store to consumer allows consumer to view supplier store products returns
 * item from supplier store to consumer writes purchase summary to supplier
 * purchase store
 * 
 * @author ramans
 *
 */
public interface DispenserApi {

	/**
	 * allows customer to see products vis ConsumerDispenserApi
	 * 
	 * @return
	 */
	public Map<String, Item> viewProductItemsFromStore();

	/**
	 * returns items from product store to consumer
	 */
	public abstract Map<String, Item> dispenseItemsFromStore(Map<String, Item> selectedCartItems);

	/**
	 * dispense change from cash store to consumer
	 */
	public abstract Map<CashEnum, Integer> dispenseChangeFromStore(int changeAmount)throws NotSufficientChangeException ;

	/**
	 * returns true if sufficient change found , else returns false if no change found
	 * @param changeAmount
	 * @return
	 */
	public abstract boolean hasSufficientChangeForAmount(int changeAmount);
	
	/**
	 * transfers user cash to supplier cash store
	 */
	public abstract void dispenseUserCashToStore(Map<CashEnum, Integer> usercash);

	/**
	 * add purchase summary once transaction completed by consumer. this will be
	 * viewed by supplier
	 */
	public abstract void addPurchaseSummaryToStore(Purchase statement);

}
