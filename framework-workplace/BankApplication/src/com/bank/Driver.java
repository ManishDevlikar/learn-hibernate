package com.bank;

import java.util.Scanner;

public class Driver {

	static Bank b = new Bank("indian Bank", "thane", "1234xcg4");

	public static void main(String[] args) {
		System.out.println("Welcome To" + " " + b.name);
		bankServices();
	}

	public static void bankServices() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1: Create Account" + " " + "2: deposite money" + " " + "3: widthrough money" + " "
				+ "4: details" + " " + "5: delete Accont" + " " + "6: exite");
		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.println("Enter Account No");
			long accNo = sc.nextLong();
			System.out.println("Enter Account Holder name");
			String accHolderName = sc.next();
			System.out.println("Enter deposite amount");
			double amount = sc.nextDouble();
			while (amount < 500) {
				System.out.println("first deposite should be more than or equal to 500");
				System.out.println("Enter deposite amount");
				amount = sc.nextDouble();
			}
			System.out.println("Enter Account type");
			String type = sc.next();

			b.CreateAccount(accNo, accHolderName, amount, type);
			bankServices();
			break;
		case 2:
			if (b.a != null) {
				System.out.println("enter amount to deposite");
				double depAmount = sc.nextDouble();
				b.depositeMoney(depAmount);
				bankServices();
			} else {
				System.out.println("create account first");
				bankServices();
			}
			break;
		case 3:
			if (b.a != null) {
				System.out.println("enter amount to widthrogh");
				double widAmount = sc.nextDouble();
				b.widthdrowMoney(widAmount);
				bankServices();
			} else {
				System.out.println("create account first");
				bankServices();
			}
			break;
		case 4:
			if (b.a != null) {
				b.getDetails();
				bankServices();
			} else {
				System.out.println("Account not found create the account");
				bankServices();
			}
			break;
		case 5:
			if (b.a != null) {

				b.deleteAccount();
				bankServices();
			} else {
				System.out.println("no such account found");
				bankServices();
			}
			break;
		case 6:
			System.out.println("Do you want to Exit (yes/no)");
			String userChoice = sc.next();
			if (userChoice.equalsIgnoreCase("yes")) {
				System.out.println("Thank you");
				break;
			} else {
				bankServices();
				break;
			}
		default:
			System.out.println("enter 6 to exit");
			bankServices();
			break;
		}
	}

}
