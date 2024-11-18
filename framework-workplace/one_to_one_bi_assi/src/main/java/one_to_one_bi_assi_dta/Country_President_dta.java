package one_to_one_bi_assi_dta;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_bi_assi_dto.Country;
import one_to_one_bi_assi_dto.President;

public class Country_President_dta {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void saveCountry(Country country) {
		if (country != null) {
			entityTransaction.begin();
			entityManager.persist(country);
			entityTransaction.commit();
		}
	}

	public void updateCountry(Country country) {
		if (country != null) {
			entityTransaction.begin();
			entityManager.merge(country);
			entityTransaction.commit();
		}
	}

	public void removeCountry(int id) {
		Country country = entityManager.find(Country.class, id);
		if (country != null) {
			entityTransaction.begin();
			entityManager.remove(country);
			entityTransaction.commit();
			System.out.println("removed");
		} else {
			System.out.println("Id is invalid");
		}
	}

	public void findCountry(int id) {
		Country country = entityManager.find(Country.class, id);
		if (country != null) {
			System.out.println(country);
		} else {
			System.out.println("Id is invalid");
		}
	}

	public void findAllCountry() {
		Query query = entityManager
				.createQuery("select country from Country country LEFT JOIN FETCH country.president");

		List<Country> list = query.getResultList();

		for (Country country : list) {
			if (country != null) {
				System.out.println(country);
			}
		}

	}

	public void savePresident(President president) {
		if (president != null) {
			entityTransaction.begin();
			entityManager.persist(president);
			entityTransaction.commit();
		}
	}

	public void updatePresident(President president) {
		if (president != null) {
			entityTransaction.begin();
			entityManager.merge(president);
			entityTransaction.commit();
		}
	}

	public void removePresident(int id) {
		President president = entityManager.find(President.class, id);
		if (president != null) {
			entityTransaction.begin();
			entityManager.remove(president);
			entityTransaction.commit();
		}
	}

	public void findPresident(int id) {
		President president = entityManager.find(President.class, id);
		if (president != null) {
			System.out.println(president);
		} else {
			System.out.println("invalid Id");
		}
	}

	public void findAllPresident() {
		Query query = entityManager
				.createQuery("select president from President president LEFT JOIN FETCH president.country");

		List<President> list = query.getResultList();

		for (President president : list) {
			if (president != null) {
				System.out.println(president);
			}
		}
	}

	public Country getCountry() {
		Country country = new Country();
		President president = new President();
		System.out.println("Enter Country Id");
		int countryId = sc.nextInt();
		country.setId(countryId);
		System.out.println("enter county name");
		String countryName = sc.next();
		country.setName(countryName);
		System.out.println("Enter county capital");
		String countryCapital = sc.next();
		country.setCapital(countryCapital);
		System.out.println("enter county population");
		String countyPopulation = sc.next();
		country.setPopulation(countyPopulation);
		System.out.println("enter president id");
		int presidentId = sc.nextInt();
		president.setId(presidentId);
		System.out.println("enter country president name");
		String presidentName = sc.next();
		president.setName(presidentName);
		System.out.println("enter president age");
		int presidentAge = sc.nextInt();
		president.setAge(presidentAge);
		president.setCountry(country);
		country.setPresident(president);
		return country;
	}

	public President getPresident() {

		Country country = new Country();
		President president = new President();
		System.out.println("enter president id");
		int presidentId = sc.nextInt();
		president.setId(presidentId);
		System.out.println("enter country president name");
		String presidentName = sc.next();
		president.setName(presidentName);
		System.out.println("enter president age");
		int presidentAge = sc.nextInt();
		president.setAge(presidentAge);
		System.out.println("Enter Country Id");
		int countryId = sc.nextInt();
		country.setId(countryId);
		System.out.println("enter county name");
		String countryName = sc.next();
		country.setName(countryName);
		System.out.println("Enter county capital");
		String countryCapital = sc.next();
		country.setCapital(countryCapital);
		System.out.println("enter county population");
		String countyPopulation = sc.next();
		country.setPopulation(countyPopulation);

		president.setCountry(country);
		country.setPresident(president);
		return president;
	}
}
