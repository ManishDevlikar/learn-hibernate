package com.composition;

public class Car {
	int cid;
	String cName;
	String brand;
	String color;
	double price;
	Eng e = new Eng(123, "petrol", "1020");

	public Car(int cid, String cName, String brand, String color, double price) {
		this.cid = cid;
		this.cName = cName;
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	public void getCarDetails() {
		System.out.println(this.cid + " " + this.cName + " " + this.brand + " " + this.color + " " + this.price);
	}
}
