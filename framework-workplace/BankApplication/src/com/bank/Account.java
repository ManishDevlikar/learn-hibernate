package com.bank;

public class Account {
	long accNo;
	String accHolderName;
	double balance;
	String type;

	public Account(long accNo, String accHolderName, double balance, String type) {
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.type = type;
	}
}
