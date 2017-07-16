package com.vending.model;

/**
 * accepted cash types
 * 
 * @author ramans
 *
 */
public enum CashEnum {

	ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100), FIVEHUNDRED(
			500), TWOTHOUSAND(2000);
	int value;

	CashEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
