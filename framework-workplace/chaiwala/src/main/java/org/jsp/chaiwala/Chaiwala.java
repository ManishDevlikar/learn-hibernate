package org.jsp.chaiwala;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Table
public class Chaiwala {
	@Id
	private int id;
	private String brand;
	private int quantity;
	private int total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total * quantity;
	}

	public void setTotal(int total) {
		this.total = total * quantity;
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Chaiwala cw = new Chaiwala();
		cw.setId(3);
		cw.setBrand("MBA");
		cw.setQuantity(5);
		cw.setTotal(10);

//		et.begin();
//		em.persist(cw);
//		et.commit();

//		et.begin();
//		em.merge(cw);
//		et.commit();

//		Chaiwala b1 = em.find(Chaiwala.class, 1);
//		System.out.println(b1.toString());
//		Chaiwala b2 = em.find(Chaiwala.class, 2);
//		System.out.println(b2.toString());

		Chaiwala b1 = em.find(Chaiwala.class, 2);

		if (b1 != null) {
			et.begin();
			em.remove(b1);
			et.commit();
		} else {
			System.out.println("Id not found");
		}

		Query q = em.createQuery("select c from Chaiwala c");
		List<Chaiwala> l = q.getResultList();
		for (Chaiwala chaiwala : l) {
			System.out.println(chaiwala);
		}
	}

	@Override
	public String toString() {
		return "Chaiwala [id=" + id + ", brand=" + brand + ", quantity=" + quantity + ", total=" + total + "]";
	}
}
