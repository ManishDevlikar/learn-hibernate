package com.composition;

public class Car1 {
	int cid;
	String cName;
	String brand;
	String color;
	double price;
	Eng1 e;

	public Car1(int cid, String cName, String brand, String color, double price, Eng1 e) {
		this.cid = cid;
		this.cName = cName;
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.e = e;
	}

	public void getCarDetails() {
		System.out.println(this.cid + " " + this.cName + " " + this.brand + " " + this.color + " " + this.price);
		e.getEngDetails();
	}
}
