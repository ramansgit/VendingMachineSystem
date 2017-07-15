package com.vending.model;

import java.util.Date;
import java.util.Set;

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
	private Set<Item> purchasedItems;

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

	public Set<Item> getPurchasedItems() {
		return purchasedItems;
	}

	public void setPurchasedItems(Set<Item> purchasedItems) {
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
