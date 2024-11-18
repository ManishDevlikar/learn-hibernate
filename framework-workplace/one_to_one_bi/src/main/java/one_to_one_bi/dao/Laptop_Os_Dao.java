package one_to_one_bi.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_bi.dt.Laptop;
import one_to_one_bi.dt.Os;

public class Laptop_Os_Dao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Laptop laptop = new Laptop();
	Os os = new Os();
	Scanner sc = new Scanner(System.in);

	public void saveLaptop(Laptop laptop) {

		entityTransaction.begin();
		entityManager.persist(laptop);
		entityTransaction.commit();
	}

	public void updateLaptop(Laptop laptop) {

		entityTransaction.begin();
		entityManager.merge(laptop);
		entityTransaction.commit();
	}

	public void printLaptop(int laptopId) {

		Laptop laptop = entityManager.find(Laptop.class, laptopId);

		if (laptop != null) {
			System.out.println(laptop);
		} else {
			System.out.println("laptop is not present");
		}

	}

	public void removeLaptop(int laptopId) {

		Laptop laptop = entityManager.find(Laptop.class, laptopId);
		if (laptop != null) {
			entityTransaction.begin();
			entityManager.remove(laptop);
			entityTransaction.commit();

		} else {
			System.out.println("invalid Id");
		}
	}

	public void printAllRecords() {

		Query query = entityManager.createQuery("select laptop  from Laptop laptop LEFT JOIN FETCH laptop.os");
		List<Laptop> list = query.getResultList();

		for (Laptop laptop : list) {
//			System.out.println(
//					laptop.getId() + " " + laptop.getPrice() + " " + laptop.getBrand() + " " + laptop.getColor());
			System.out.println(laptop);

//			if (laptop.getOs() != null) {
////				System.out.println(
////						laptop.getOs().getId() + " " + laptop.getOs().getBit() + " " + laptop.getOs().getType());
//			System.out.println(laptop.getOs());
//
//			}
		}
	}

	public void saveOs(Os os) {

		entityTransaction.begin();
		entityManager.persist(os);
		entityTransaction.commit();
	}

	public void updateOs(Os os) {

		entityTransaction.begin();
		entityManager.merge(os);
		entityTransaction.commit();
	}

	public void deleteOs(int osId) {
		Os os = entityManager.find(Os.class, osId);
		if (os != null) {
			entityTransaction.begin();
			entityManager.remove(os);
			entityTransaction.commit();

		} else {
			System.out.println("data not present");
		}
	}

	public void printOs(int osId) {
		Os os = entityManager.find(Os.class, osId);
		if (os != null) {
			System.out.println(os);
		}
	}

	public void printAllOs() {
		Query query = entityManager.createQuery("select os from Os os LEFT JOIN FETCH os.laptop ");

		List<Os> list = query.getResultList();

		for (Os os : list) {
			if (os != null) {
				System.out.println(os);
			} else {
				System.out.println("os is empty");
			}
		}
	}

	public Laptop createLaptop() {
		System.out.println("enter laptopId");
		int id = sc.nextInt();
		laptop.setId(id);
		System.out.println("enter laptopBrand");
		String brand = sc.next();
		laptop.setBrand(brand);
		System.out.println("enter laptopColor");
		String color = sc.next();
		laptop.setColor(color);
		System.out.println("enter laptopPrice");
		double price = sc.nextDouble();
		laptop.setPrice(price);
		System.out.println("do you want to save laptop as well press 1:  or press any key To exit");
		int input = sc.nextInt();
		if (input == 1) {

			System.out.println("enter osId");
			int osId = sc.nextInt();
			System.out.println("enter osBit");
			int osBit = sc.nextInt();
			System.out.println("enter osType");
			String osType = sc.next();
			os.setId(osId);
			os.setBit(osBit);
			os.setType(osType);
			laptop.setOs(os);
			os.setLaptop(laptop);
		} else {
			return laptop;
		}

		return laptop;
	}

	public Os createOs() {
		System.out.println("enter osId");
		int osId = sc.nextInt();
		os.setId(osId);
		System.out.println("enter osBit");
		int osBit = sc.nextInt();
		System.out.println("enter osType");
		os.setBit(osBit);
		String osType = sc.next();
		os.setType(osType);
		System.out.println("do you want to save Os as well press 1:  or press any key To exit");
		int input = sc.nextInt();
		if (input == 1) {

			System.out.println("enter laptopId");
			int id = sc.nextInt();
			System.out.println("enter laptopBrand");
			String brand = sc.next();
			System.out.println("enter laptopColor");
			String color = sc.next();
			System.out.println("enter laptopPrice");
			double price = sc.nextDouble();

			laptop.setId(id);
			laptop.setBrand(brand);
			laptop.setColor(color);
			laptop.setPrice(price);
			laptop.setOs(os);
			os.setLaptop(laptop);
		} else {
			return os;
		}

		return os;
	}
}
