package caching.controller;

import caching.dao.Caching_Dao;
import caching.dto.Bike;

public class Caching_Controller {

	static Caching_Dao dao = new Caching_Dao();

	public static void main(String[] args) {
		Bike bike1 = new Bike();
		bike1.setId(101);
		bike1.setName("zenicorn");
		bike1.setPrice(800000);

		Bike bike2 = new Bike();
		bike2.setId(102);
		bike2.setName("PKM");
		bike2.setPrice(80000);

		Bike bike3 = new Bike();
		bike3.setId(103);
		bike3.setName("NUCK");
		bike3.setPrice(90000);

		Bike bike4 = new Bike();
		bike4.setId(104);
		bike4.setName("parley Devidson");
		bike4.setPrice(90000);

		Bike bike5 = new Bike();
		bike5.setId(105);
		bike5.setName("XMW");
		bike5.setPrice(90000);

//		dao.save(bike1);
//		dao.save(bike2);
//		dao.save(bike3);
//		dao.save(bike4);
//		dao.save(bike5);
		Bike b1 = dao.find(101);
		Bike b2 = dao.find(101);
		Bike b3 = dao.find(102);
//
		System.out.println(b1);
		System.out.println(b3);
		System.out.println(b2);
		System.out.println(b3);
	}

}
