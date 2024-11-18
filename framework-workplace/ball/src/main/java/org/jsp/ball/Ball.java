package org.jsp.ball;

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
public class Ball {
	@Id
	private int id;
	private String brand;
	private double price;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Ball b = new Ball();
		b.setId(103);
		b.setBrand("SG");
		b.setPrice(100.0);

//		to insert record
//		et.begin();
//		em.persist(b);
//		et.commit();
//		to update record
//		et.begin();
//		em.merge(b);
//		et.commit();

		Ball b1 = em.find(Ball.class, 101);
		System.out.println(b1.toString());
		Ball b2 = em.find(Ball.class, 102);
		System.out.println(b2.toString());

		Query q = em.createQuery("select b from Ball b");
		List<Ball> l = q.getResultList();
		for (Ball ball : l) {
			System.out.println(ball);
		}
	}

	@Override
	public String toString() {
		return "Ball [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}

}
