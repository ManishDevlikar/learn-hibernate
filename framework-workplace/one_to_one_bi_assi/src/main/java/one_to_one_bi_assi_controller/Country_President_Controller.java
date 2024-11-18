package one_to_one_bi_assi_controller;

import java.util.Scanner;

import one_to_one_bi_assi_dta.Country_President_dta;
import one_to_one_bi_assi_dto.Country;
import one_to_one_bi_assi_dto.President;

public class Country_President_Controller {
	static Scanner sc = new Scanner(System.in);
	static Country_President_dta country_President_dta = new Country_President_dta();

	public static void main(String[] args) {
		runApplication();
	}

	public static void runApplication() {
		System.out.println("1:createCountry  2:updateCountry 3:deleteCountry 4:findCounty  5:findAllCountry \n"
				+ " 6:createPresident   7:updatePresident  8:deletePresident  9:findPresident 10:findAllPresident  11:Exit");

		int input = sc.nextInt();
		switch (input) {
		case 1:
			Country country = country_President_dta.getCountry();
			country_President_dta.saveCountry(country);
			runApplication();
			break;
		case 2:
			Country countryUpdate = country_President_dta.getCountry();
			country_President_dta.updateCountry(countryUpdate);
			runApplication();
			break;
		case 3:
			System.out.println("enter country id to delete record");
			int countryId = sc.nextInt();
			country_President_dta.removeCountry(countryId);
			runApplication();
			break;
		case 4:
			System.out.println("Enter id to find country");
			int findCountryId = sc.nextInt();
			country_President_dta.findCountry(findCountryId);
			runApplication();
			break;
		case 5:
			System.out.println("All rescord");
			country_President_dta.findAllCountry();
			runApplication();
			break;
		case 6:
			President president = country_President_dta.getPresident();
			country_President_dta.savePresident(president);
			runApplication();
			break;
		case 7:
			President presidentUpdate = country_President_dta.getPresident();
			country_President_dta.updatePresident(presidentUpdate);
			runApplication();
			break;
		case 8:
			System.out.println("enter President id to delete record");
			int presidentId = sc.nextInt();
			country_President_dta.removePresident(presidentId);
			runApplication();
			break;
		case 9:
			System.out.println("Enter id to find President");
			int findPresidentId = sc.nextInt();
			country_President_dta.findPresident(findPresidentId);
			runApplication();
			break;
		case 10:
			System.out.println("All rescord");
			country_President_dta.findAllPresident();
			runApplication();
			break;
		case 11:
			System.out.println("Thank you");
			break;
		default:
			System.out.println("wrong input");
			runApplication();
			break;
		}
	}
}
