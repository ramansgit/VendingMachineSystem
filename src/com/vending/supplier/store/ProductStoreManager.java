package com.vending.supplier.store;

import java.util.LinkedHashMap;
import java.util.Map;

import com.vending.model.Item;

/**
 * product store manager to manage the product items
 * 
 * @author ramans
 *
 */
public class ProductStoreManager {

	public static ProductStoreManager instance = null;
	private Map<String, Item> itemsFromStore = new LinkedHashMap<String, Item>();

	/**
	 * private constructor
	 */
	private ProductStoreManager() {

	}

	/**
	 * singleton pattern followed to create only one instance of this class
	 * 
	 * @return
	 */
	public static ProductStoreManager getInstance() {
		if (instance == null) {
			instance = new ProductStoreManager();
		}
		return instance;
	}

	/**
	 * returns available product items
	 * 
	 * @return
	 */
	public Map<String, Item> getItemsFromStore() {
		return itemsFromStore;
	}

	/**
	 * add one item to product store
	 * 
	 * @param item
	 * @throws ProductExistException
	 */
	public void addItemToStore(Item item) {
		if (item != null) {
			if (item.getProductId() != null && !item.getProductId().isEmpty()) {
				if (!hasProductItem(item.getProductId())) {
					itemsFromStore.put(item.getProductId(), item);
				} 

			}
		}

	}

	/**
	 * checks whether product exist in the store
	 * @param productId
	 * @return
	 */
	public boolean hasProductItem(String productId) {
		if (productId != null && !productId.isEmpty()) {
			return itemsFromStore.containsKey(productId);
		}
		return false;
	}

	/**
	 * reset item store
	 */
	public void resetStore() {
		itemsFromStore.clear();
	}

}
