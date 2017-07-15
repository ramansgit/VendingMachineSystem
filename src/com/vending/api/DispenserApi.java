package com.vending.api;

public interface DispenserApi {

	/**
	 * dispenser returns item to the tray when payment done 
	 */
	public abstract void dispenseItemToTray();
	
	/**
	 * dispenser refunds cash back when consumer cancels purchase before confirmation
	 */
	public abstract void dispenseRefundToTray();
	
	/**
	 * dispense change to tray when payment done 
	 */
	public abstract void dispenseChangeToTray();
	
	
	
}
