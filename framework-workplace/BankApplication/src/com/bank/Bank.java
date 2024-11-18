package com.bank;

public class Bank {
	String name;
	String branch;
	String ifsc;
	Account a;

	public Bank(String name, String branch, String ifsc) {
		this.name = name;
		this.branch = branch;
		this.ifsc = ifsc;
	}

	public void CreateAccount(long accNo, String accHolderName, double balance, String type) {
		if (balance >= 500) {
			a = new Account(accNo, accHolderName, balance, type);
			System.out.println("Account created");
		} else {
			System.out.println("first deposite should be more than or equal to 500");
		}
	}

	public void widthdrowMoney(double amount) {
		if (a != null) {
			if (amount < a.balance && a.balance > 500.0 && a.balance - amount >= 500) {
				a.balance = a.balance - amount;
				System.out.println("you widthrough:" + " " + amount);

			} else {
				System.out.println("your account balance is insufficient");
			}
		} else {

			System.out.println("Acconut not found");
		}
	}

	public void depositeMoney(double amount) {
		if (a != null) {
			a.balance = a.balance + amount;
			System.out.println("you deposite: " + amount);

		} else {
			System.out.println("Create Account first");
		}
	}

	public void getDetails() {
		if (a != null) {
			System.out.println("Account No:  " + a.accNo);
			System.out.println("Owner Name:  " + a.accHolderName);
			System.out.println("Balance:  " + a.balance);
			System.out.println("Account type:  " + a.type);
		} else {
			System.out.println("account not fount");
		}
	}

	public void deleteAccount() {
		if (a != null) {

			a = null;
			System.out.println("Account deleted");
		} else {
			System.out.println("account not found");
		}
	}
}
