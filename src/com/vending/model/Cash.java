package com.vending.model;

import com.vending.utils.CashEnum;

/**
 * pojo class carries cash information
 * 
 * @author ramans
 *
 */
public class Cash {
	/**
	 * money
	 */
	private CashEnum denominations;
	/**
	 * denominations
	 */
	private int qty;

	public Cash() {

	}

	public Cash(CashEnum denominations, int qty) {
		this.qty = qty;
		this.denominations = denominations;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public CashEnum getDenominations() {
		return denominations;
	}

	public void setDenominations(CashEnum denominations) {
		this.denominations = denominations;
	}

	@Override
	public String toString() {
		return "Cash [qty=" + qty + ", denominations=" + denominations + "]";
	}

}
