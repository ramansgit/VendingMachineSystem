package com.vending.model;

/**
 * 
 * @author ramans
 * pojo class carries item information
 */
public class Item {

	/**
	 * product id 
	 */
	private String productId;
	/**
	 * product name
	 */
	private String name;
	/**
	 * product price
	 */
	private int price;
	/**
	 * product qty
	 */
	private int qty;
	
	public Item() {

	}

	public Item(String productId, String name, int price, int qty) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", qty=" + qty + ", productId=" + productId + "]";
	}

}
