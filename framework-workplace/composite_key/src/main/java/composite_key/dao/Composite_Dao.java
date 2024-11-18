package composite_key.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import composite_key.dto.Amazon;

public class Composite_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	public void save(Amazon amazon) {
		transaction.begin();
		manager.persist(amazon);
		transaction.commit();
	}
}
