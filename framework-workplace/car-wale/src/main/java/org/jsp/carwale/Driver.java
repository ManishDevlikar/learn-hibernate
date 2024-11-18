package org.jsp.carwale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Driver {
	public static void main(String[] args) {
		Carwale car = new Carwale();
		car.getNew(8, "suzuki", "dezire", 1, "8 lakh");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Query q = em.createQuery("select car from Carwale car");
//
//		Carwale.insert(em, et, car); // to insert
//		Carwale.update(em, et, car); // to update
//		Carwale.fetch(em, 10); // to fetch
//		Carwale.remove(em, et, 8); // to remove
		Carwale.getAll(q); // to get all records
	}

}
