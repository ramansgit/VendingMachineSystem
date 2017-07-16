package com.vending.model;

import java.util.Date;
import java.util.Map;

/**
 * Pojo class carries purchase summary
 * 
 * @author ramans
 *
 */
public class Purchase {

	/**
	 * transactionId
	 */
	private String transactionId;
	/**
	 * created date
	 */
	private Date createDate;
	/**
	 * purchased items
	 */
	private Map<String,Item> purchasedItems;

	/**
	 * total amount
	 */
	private int totalAmout;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Map<String,Item> getPurchasedItems() {
		return purchasedItems;
	}

	public void setPurchasedItems(Map<String,Item> purchasedItems) {
		this.purchasedItems = purchasedItems;
	}

	public int getTotalAmout() {
		return totalAmout;
	}

	public void setTotalAmout(int totalAmout) {
		this.totalAmout = totalAmout;
	}

	@Override
	public String toString() {
		return "Purchase [transactionId=" + transactionId + ", createDate=" + createDate + ", purchasedItems="
				+ purchasedItems + ", totalAmout=" + totalAmout + "]";
	}

}
