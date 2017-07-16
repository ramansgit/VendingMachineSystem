package com.vending.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * this class responsible for returning item and change to customer
 * @author ramans
 *
 */
public class DispenseItemAndChange {

	
	@Override
	public String toString() {
		return "DispenseItemAndChange [change=" + change + ", items=" + items + "]";
	}

	private Map<CashEnum, Integer> change = new TreeMap<CashEnum, Integer>();
	private Map<String, Item> items = new LinkedHashMap<String, Item>();
	
	public DispenseItemAndChange(Map<CashEnum, Integer> change, Map<String, Item> items){
		this.change = change;
		this.items = items;
	}
	
	public Map<CashEnum, Integer> getChange() {
		return change;
	}
	public void setChange(Map<CashEnum, Integer> change) {
		this.change = change;
	}
	
	public Map<String, Item> getItems() {
		return items;
	}

	public void setItems(Map<String, Item> items) {
		this.items = items;
	}

}
