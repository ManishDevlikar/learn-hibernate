package org.jsp.electronics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {
		ECommerce e = new ECommerce();

		e.setItemId(103);
		e.setItemName("Mac Book Air3 pro");
		e.setItemBrand("Apple");
		e.setItemPrice(100000);
		e.setItemCount(1);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

//		insert
//		et.begin();
//		em.persist(e);
//		et.commit();

//		update
//		et.begin();
//		em.merge(e);
//		et.commit();

//		find
//		ECommerce res = em.find(ECommerce.class, 101);
//		System.out.println(res.toString());

//		remove
//		ECommerce data = em.find(ECommerce.class, 101);
//		et.begin();
//		em.remove(data);
//		et.commit();

//		return all data
//		Query q = em.createQuery("select item from ECommerce item");
//		List<ECommerce> l = q.getResultList();
//
//		for (ECommerce res : l) {
//			System.out.println(res);
//		}
	}

}
