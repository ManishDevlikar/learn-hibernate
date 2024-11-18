package one_to_one_bi.controller;

import java.util.Scanner;

import one_to_one_bi.dao.Laptop_Os_Dao;
import one_to_one_bi.dt.Laptop;
import one_to_one_bi.dt.Os;

public class Laptop_Os_Controller {
	static Laptop_Os_Dao laptop_Os_Dao = new Laptop_Os_Dao();

	public static void main(String[] args) {
		runApplication();

	}

	public static void runApplication() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1:createLaptop  2:updateLaptop 3:deleteLaptop 4:findLaptop  5:findAllLaptop \n"
				+ " 6:createOs   7:updateOs  8:deleteOs  9:findOs 10:findAllOs  11:Exit");

		int input = sc.nextInt();
		switch (input) {
		case 1:
			Laptop laptop = laptop_Os_Dao.createLaptop();
			laptop_Os_Dao.saveLaptop(laptop);
			runApplication();
			break;
		case 2:
			Laptop laptopUpdate = laptop_Os_Dao.createLaptop();
			laptop_Os_Dao.updateLaptop(laptopUpdate);
			runApplication();
			break;
		case 3:
			System.out.println("Enter LaptopId to delete laptop");
			int laptopId = sc.nextInt();
			laptop_Os_Dao.removeLaptop(laptopId);
			runApplication();
			break;
		case 4:
			System.out.println("enter laptop id to find record");
			int findLaptopId = sc.nextInt();
			laptop_Os_Dao.printLaptop(findLaptopId);
			runApplication();
			break;
		case 5:
			System.out.println("All laptop records are");
			laptop_Os_Dao.printAllRecords();
			runApplication();
			break;
		case 6:
			Os os = laptop_Os_Dao.createOs();
			laptop_Os_Dao.saveOs(os);
			runApplication();
			break;
		case 7:
			Os osUpdate = laptop_Os_Dao.createOs();
			laptop_Os_Dao.updateOs(osUpdate);
			runApplication();
			break;
		case 8:
			System.out.println("enter os id to remove record");
			int osRemoveId = sc.nextInt();
			laptop_Os_Dao.deleteOs(osRemoveId);
			runApplication();
			break;
		case 9:
			System.out.println("Enter os id to find os record");
			int findOsId = sc.nextInt();
			laptop_Os_Dao.printOs(findOsId);
			runApplication();
			break;
		case 10:
			System.out.println("all os records");
			laptop_Os_Dao.printAllOs();
			runApplication();
			break;
		case 11:
			System.out.println("thak ypu");
			return;
		default:
			System.out.println("wrong input");
			runApplication();
			break;
		}
	}
}
