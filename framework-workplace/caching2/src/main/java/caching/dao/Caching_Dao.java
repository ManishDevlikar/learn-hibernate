package caching.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import caching.dto.Bike;

public class Caching_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	public void save(Bike bike) {
		transaction.begin();
		manager.persist(bike);
		transaction.commit();
	}

	public void saveList(List<Bike> bikes) {
		for (Bike bike : bikes) {
			transaction.begin();
			manager.persist(bike);
			transaction.commit();
		}
	}

	public Bike find(int id) {
		Bike bike = manager.find(Bike.class, id);

		if (bike != null) {
			return bike;
		} else {
			return null;
		}

	}
}
