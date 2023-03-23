package com.supermarket.billing.ExceptionCentral;

public class BillNotFoundException extends RuntimeException{
	public BillNotFoundException() {
		super("Sorry ! expected bill not found");
	}
}
