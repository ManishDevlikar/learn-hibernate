package many_to_one_bi_assi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import many_to_one_bi_assi.dao.Customer_bank_Dao;
import many_to_one_bi_assi.dto.Bank;
import many_to_one_bi_assi.dto.Customer;

public class Customer_Bank_Controller {
	static Customer_bank_Dao dao = new Customer_bank_Dao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		runApplication();
	}

	public static void runApplication() {
		System.out.println("Enter your Choice : " + "\n1: To Add Bank " + "\n2: Add new Account To Bank "
				+ "\n3: Change Accounts Bank " + "\n4: Remove Account \n5: Remove Bank "
				+ "\n6: Remove Account From Bank " + "\n7: Find Bank By Id "
				+ "\n8: Find Account By Id \n9: Find Bank With Accounts \n10: find All Records \n11: Exit");

		int userChoice = sc.nextInt();
		switch (userChoice) {
		case 1:
			System.out.println("Do you want To Add New Bank (Yes/no)");
			String toCreateNewBank = sc.next();
			if (toCreateNewBank.equalsIgnoreCase("yes")) {
				Bank bank = new Bank();
				System.out.println("Enter Bank Id");
				int newBankId = sc.nextInt();
				bank.setId(newBankId);
				System.out.println("Enter Bank Name");
				String newBankName = sc.next();
				bank.setName(newBankName);
				System.out.println("Enter Bank IFSC code ");
				String newIfscCode = sc.next();
				bank.setIfsc(newIfscCode);
				System.out.println("Enter Bank Address");
				String newBankAdd = sc.next();
				bank.setAddress(newBankAdd);

				System.out.println("do you want to add Account (Yes/no)");
				String toAddCustomers = sc.next();
				if (toAddCustomers.equalsIgnoreCase("yes")) {
					List<Customer> custList = new ArrayList<Customer>();
					System.out.println("How many Accounts you want to add");
					int totalCustToAdd = sc.nextInt();
					for (int i = 1; i <= totalCustToAdd; i++) {
						Customer customer = new Customer();
						System.out.println("Enter Account Id");
						int newCustId = sc.nextInt();
						customer.setId(newCustId);
						System.out.println("Enter Account Holder Name");
						String newCustName = sc.next();
						customer.setName(newCustName);
						System.out.println("Enter Account Holder Addresss");
						String newCustAddress = sc.next();
						customer.setAddress(newCustAddress);
						System.out.println("Enter account no");
						String newAccountNo = sc.next();
						customer.setAccountNo(newAccountNo);
						System.out.println(i + " account Created");
						custList.add(customer);
						customer.setBank(bank);
					}
					bank.setCustomer(custList);
					dao.saveBank(bank);
					runApplication();
					break;
				} else {
					dao.saveBank(bank);
					runApplication();
					break;
				}

			} else {
				runApplication();
				break;
			}
		case 2:
			System.out.println("Do you want To Add New Acconut to bank(Yes/no)");
			String toAddNewCust = sc.next();
			if (toAddNewCust.equalsIgnoreCase("yes")) {
				System.out.println("Enter bank id in which you want to add Account");
				int bankId = sc.nextInt();
				System.out.println("now add the new Account detalis");
				Customer customer = new Customer();
				System.out.println("Enter Customer Id");
				int newCustId = sc.nextInt();
				customer.setId(newCustId);
				System.out.println("Enter Account holder Name");
				String newCustName = sc.next();
				customer.setName(newCustName);
				System.out.println("Enter Account Holder Addresss");
				String newCustAddress = sc.next();
				customer.setAddress(newCustAddress);
				System.out.println("Enter  account no");
				String newAccountNo = sc.next();
				customer.setAccountNo(newAccountNo);
				dao.addCustomer(bankId, customer);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}

		case 3:
			System.out.println("Do you want To change Accountant Bank (Yes/no)");
			String changeBank = sc.next();
			if (changeBank.equalsIgnoreCase("yes")) {
				System.out.println("Enter new Bank Id");
				int bankId = sc.nextInt();
				System.out.println("Enter account Id");
				int accId = sc.nextInt();
				dao.changeBank(bankId, accId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 4:
			System.out.println("Do you want To Remove Account (Yes/no)");
			String toRemoveAcc = sc.next();
			if (toRemoveAcc.equalsIgnoreCase("yes")) {
				System.out.println("Enter account id to remove");
				int accId = sc.nextInt();
				dao.removeCustomer(accId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 5:
			System.out.println("Do you want To Remove Bank (Yes/no)");
			String toRemoveBank = sc.next();
			if (toRemoveBank.equalsIgnoreCase("yes")) {
				System.out.println("Enter Bank Id to remove");
				int bankId = sc.nextInt();
				dao.removeBankWithAccounts(bankId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 6:
			System.out.println("Do you want To Remove Acconut From Bank (Yes/no)");
			String toRemoveAccFromBank = sc.next();
			if (toRemoveAccFromBank.equalsIgnoreCase("yes")) {
				System.out.println("enter account id");
				int accId = sc.nextInt();
				dao.removeCustomerFromBank(accId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 7:
			System.out.println("Enter bank id to find");
			int getBankById = sc.nextInt();
			dao.findBank(getBankById);
			runApplication();
			break;
		case 8:
			System.out.println("Enter account Id to find");
			int getAccById = sc.nextInt();
			dao.findCustomer(getAccById);
			runApplication();
			break;

		case 9: {
			System.out.println("Enetr Bank id To get All detalis");
			int findBank = sc.nextInt();
			dao.findBankWithCustomers(findBank);
			runApplication();
			break;
		}
		case 10: {
			System.out.println("All Records Are:");
			dao.findAllRecords();
			runApplication();
			break;
		}
		case 11: {
			System.out.println("do you want to exit: Yes/No");
			String input = sc.next();
			if (input.equalsIgnoreCase("yes")) {
				System.out.println("Thank You");
				break;
			} else {
				runApplication();
				break;
			}
		}
		default: {
			System.out.println("Enter 11 To Exit");
			runApplication();
			break;
		}

		}
	}
}
