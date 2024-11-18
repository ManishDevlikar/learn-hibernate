package org.jsp.carwale;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Table
public class Carwale {
	@Id
	private int id;
	private String name;
	private String brand;
	private int inStock;
	private String price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Carwale [id=" + id + ", name=" + name + ", brand=" + brand + ", inStock=" + inStock + ", price=" + price
				+ "]";
	}

	public void getNew(int id, String brand, String name, int inStock, String price) {
		this.setId(id);
		this.setBrand(brand);
		this.setName(name);
		this.setInStock(inStock);
		this.setPrice(price);
	}

	public static void insert(EntityManager em, EntityTransaction et, Carwale car) {
		et.begin();
		em.persist(car);
		et.commit();
	}

	public static void update(EntityManager em, EntityTransaction et, Carwale car) {
		et.begin();
		em.merge(car);
		et.commit();
	}

	public static void fetch(EntityManager em, int id) {
		Carwale car = em.find(Carwale.class, id);
		if (car != null) {
			System.out.println(car.toString());
		} else {
			System.out.println("Id Not Found");
		}
	}

	public static void remove(EntityManager em, EntityTransaction et, int id) {
		Carwale car = em.find(Carwale.class, id);
		if (car != null) {
			et.begin();
			em.remove(car);
			et.commit();
		} else {
			System.out.println("Id not Present");
		}
	}

	public static void getAll(Query q) {
		List<Carwale> l = q.getResultList();
		for (Carwale carwale : l) {
			System.out.println(carwale);
		}
	}
}
