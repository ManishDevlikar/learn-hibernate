package com.zpractice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;

public class Driver {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Customer customer = new Customer();
		customer.setName("alice");
		customer.setCity("dunge");

		Set<Order> list = new HashSet<>();
		Order order1 = new Order();
		order1.setProduct("activa");
		order1.setQuantity(1);
		Order order2 = new Order();
		order2.setProduct("computer");
		order2.setQuantity(2);
		list.add(order2);
		list.add(order1);
		for (Order order : list) {
			order.setCustomer(customer);
		}
//		customer.setOrders(list);
//		Transaction transaction = session.beginTransaction();
//		session.persist(customer);
//		session.persist(order1);
//		session.persist(order2);
//		transaction.commit();
//		System.out.println("record saved");

//

//		System.out.println(qc.getFirst());

//		List<Customer> query = session.createQuery("select s from Customer s where s.id=2", Customer.class).list();
//		System.out.println(query);

//		List<Customer> cus = session.createQuery("from Customer s where s.id=:cId", Customer.class)
//				.setParameter("cId", "2").getResultList();
//		System.out.println(cus);

//		Transaction transaction = session.beginTransaction();
//
//		// Delete Orders first
//		String deleteOrders = "DELETE FROM Order WHERE customer.id = :customerId";
//		session.createMutationQuery(deleteOrders).setParameter("customerId", 1).executeUpdate();
//
//		// Then delete Customer
//		String deleteCustomer = "DELETE FROM Customer WHERE id = :customerId";
//		session.createQuery(deleteCustomer).setParameter("customerId", 1).executeUpdate();
//
//		transaction.commit();
//
//		System.out.println("deleted");

		/*
		 * String hql =
		 * "UPDATE Customer SET city = :city, name = :name WHERE id = :customerId"; int
		 * updatedCount = session.createQuery(hql) .setParameter("city", "New City")
		 * .setParameter("name", "Updated Name") .setParameter("customerId", 1L)
		 * .executeUpdate();
		 * 
		 */

//		Transaction transaction = session.beginTransaction();
//		session.createMutationQuery("UPDATE Customer SET name=:name, city=:place where id=:cid")
//				.setParameter("name", "emmie").setParameter("place", "bhiwandi").setParameter("cid", 2).executeUpdate();
//		session.flush();
//		transaction.commit();

		/*
		 * String hql =
		 * "UPDATE Order SET product = :product, quantity = :quantity WHERE id = :orderId AND customer.id = :customerId"
		 * ; int updatedCount = session.createMutationQuery(hql)
		 * .setParameter("product", "Tablet") .setParameter("quantity", 3)
		 * .setParameter("orderId", 1L) .setParameter("customerId", 1L)
		 * .executeUpdate();
		 * 
		 * transaction.commit();
		 * 
		 */
//		Transaction transaction = session.beginTransaction();
//		session.createMutationQuery(
//				"Update Order Set product=:product where id=:orderId AND customer.id=:customerId")
//				.setParameter("product", "house").setParameter("orderId", 3)
//				.setParameter("customerId", 2).executeUpdate();
//		transaction.commit();

//		try {
//			Query<Customer> q = session.createQuery("from Customer", Customer.class);
//			List<Customer> qc = q.getResultList();
//			System.out.println(qc);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

		// Join Query

//		String hql = "SELECT o FROM Order o JOIN o.customer c WHERE c.name = :customerName";
//		List<Order> orders = session.createQuery(hql, Order.class).setParameter("customerName", "Jane Doe").list();

//		List<Order> list2 = session
//				.createQuery("select o from Order o join o.customer c where c.name=:cname", Order.class)
//				.setParameter("cname", "emmie").getResultList();
//		System.out.println(list2);

		// Native SQL Queries

//		Customer uniqueResult = session.createNativeQuery("select * from customers where id=:id", Customer.class)
//				.setParameter("id", 2).uniqueResult();
//		System.out.println(uniqueResult);
//
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
//		ParameterExpression<Integer> custId = criteriaBuilder.parameter(Integer.class);
//		Root<Customer> root = query.from(Customer.class);
//		query.select(root).where(criteriaBuilder.equal(root.get("id"), custId));
//		TypedQuery<Customer> tq = session.createQuery(query);
//		tq.setParameter(custId, 2);
//		List<Customer> results = tq.getResultList();
//		System.out.println(results);

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = query.from(Customer.class);

		// Using a placeholder parameter
		ParameterExpression<Integer> idParam = criteriaBuilder.parameter(Integer.class);
		query.select(root).where(criteriaBuilder.equal(root.get("id"), idParam));

		TypedQuery<Customer> typedQuery = session.createQuery(query);
		typedQuery.setParameter(idParam, 2);

		List<Customer> results = typedQuery.getResultList();
		System.out.println(results);

	}
}
