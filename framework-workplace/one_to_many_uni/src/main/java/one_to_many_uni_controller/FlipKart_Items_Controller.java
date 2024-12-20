package one_to_many_uni_controller;

import java.util.Scanner;

import one_to_many_uni_dao.FlipKart_Items_Dao;

public class FlipKart_Items_Controller {
	static FlipKart_Items_Dao flipKart_Items_Dao = new FlipKart_Items_Dao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		runApplication();

	}

	public static void runApplication() {
		System.out.println("1: save Flipcart" + " \n2: update Account info" + " \n3: delete Flipkart"
				+ " \n4: Find Record" + " \n5: find All Records" + " \n6: Add new items"
				+ " \n7: update Item Quantity + " + "\n8: delete item" + "\n9: Exit");

		int input = sc.nextInt();

		switch (input) {
		case 1:
			flipKart_Items_Dao.getFlipKart();
			runApplication();
			break;
		case 2:
			System.out.println("Enter your Account Id to update Account info");
			int accountId = sc.nextInt();
			flipKart_Items_Dao.updateAccountInfo(accountId);
			runApplication();
			break;
		case 3:
			System.out.println("do you want to delete your Account (Yes or No)");
			String decision = sc.next();
			if (decision.equalsIgnoreCase("yes")) {
				int accountIdToDelete = sc.nextInt();
				flipKart_Items_Dao.deleteFlipKart(accountIdToDelete);
			} else {
				runApplication();
			}
			break;
		case 4:
			System.out.println("enter flipkart id to get all the info.");
			int getDetailsById = sc.nextInt();
			flipKart_Items_Dao.findFlipKart(getDetailsById);
			runApplication();
			break;
		case 5:
			flipKart_Items_Dao.findAllFlipKart();
			runApplication();
			break;
		case 6:
			System.out.println("enter your account id");
			int toAddNewItems = sc.nextInt();
			flipKart_Items_Dao.addNewItems(toAddNewItems);
			runApplication();
			break;
		case 7:
			System.out.println("to update quantity of item enter your item id");
			int itemIdToUpdate = sc.nextInt();
			flipKart_Items_Dao.updateItem(itemIdToUpdate);
			runApplication();
			break;
		case 8:
			System.out.println("do you want to delete your item (Yes or No)");
			String toDeleteItem = sc.next();
			if (toDeleteItem.equalsIgnoreCase("yes")) {
				System.out.println("enter your account id");
				int accountIdToDeleteItem = sc.nextInt();
				System.out.println("enter item id");
				int itemIdToDelete = sc.nextInt();
				flipKart_Items_Dao.deleteItemById(accountIdToDeleteItem, itemIdToDelete);
				runApplication();
			} else {
				runApplication();
			}
			break;
		case 9:
			System.out.println("thank you");
			break;
		default:
			System.out.println("you entered wrong input");
			runApplication();
		}

	}
}
