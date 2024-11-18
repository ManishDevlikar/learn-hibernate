package one_to_one_uni.controller;

import java.util.Scanner;

import one_to_one_uni.dao.Person_Passport_Dao;
import one_to_one_uni.dto.Passport;
import one_to_one_uni.dto.Person;

public class Person_Passport_Controller {
	static Scanner sc = new Scanner(System.in);
	static Person_Passport_Dao dao = new Person_Passport_Dao();

	public static void main(String[] args) {
		runApplication();
	}

	public static void runApplication() {
		System.out
				.println("Enter 1: insert date  2: update data  3:delete data  4:find data  5: print records  6:exit");

		int input = sc.nextInt();

		switch (input) {
		case 1:
			Passport passport = new Passport();
			System.out.println("Enter Id");
			int id = sc.nextInt();
			passport.setpId(id);
			System.out.println("Enter natinality");
			String nation = sc.next();
			passport.setOrigine(nation);
			System.out.println("Enter issue date");
			String issueDate = sc.next();
			passport.setDate_Of_Issue(issueDate);
			Person person = new Person();
			System.out.println("Enter person id");
			int personId = sc.nextInt();
			person.setId(personId);
			System.out.println("Enter person name");
			String personName = sc.next();
			person.setName(personName);
			System.out.println("Enter person age");
			int personAge = sc.nextInt();
			person.setAge(personAge);
			System.out.println("Enter mobile number");
			long mobileNo = sc.nextLong();
			person.setMno(mobileNo);
			person.setPassport(passport);
			dao.savePerson(person);
			runApplication();
			break;

		case 2:
			Passport passportUpdate = new Passport();
			System.out.println("Enter Id");
			int idUpdate = sc.nextInt();
			passportUpdate.setpId(idUpdate);
			System.out.println("Enter natinality");
			String nationUpdate = sc.next();
			passportUpdate.setOrigine(nationUpdate);
			System.out.println("Enter issue date");
			String issueDateUpdate = sc.next();
			passportUpdate.setDate_Of_Issue(issueDateUpdate);
			Person personUpdate = new Person();
			System.out.println("Enter person id");
			int personIdUpdate = sc.nextInt();
			personUpdate.setId(personIdUpdate);
			System.out.println("Enter person name");
			String personNameUpdate = sc.next();
			personUpdate.setName(personNameUpdate);
			System.out.println("Enter person age");
			int personAgeUpdate = sc.nextInt();
			personUpdate.setAge(personAgeUpdate);
			System.out.println("Enter mobile number");
			long mobileNoUpdate = sc.nextLong();
			personUpdate.setMno(mobileNoUpdate);
			personUpdate.setPassport(passportUpdate);
			dao.updatePerson(personUpdate);
			runApplication();
			break;

		case 3:
			System.out.println("Enter id to remove from database");
			int removeId = sc.nextInt();
			dao.removePerson(removeId);
			runApplication();
			break;

		case 4:
			System.out.println("Enter id to find record");
			int printIdDetails = sc.nextInt();
			dao.printPerson(printIdDetails);
			runApplication();
			break;
		case 5:
			dao.printAllPersons();
			runApplication();
			break;
		case 6:
			System.out.println("Thank u");
			return;

		default:
			System.out.println("invalid input");
			break;
		}
	}

}
