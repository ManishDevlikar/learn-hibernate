package com.bag;

public class Bag {
	String color;
	String brand;
	double price;
	int noOfCompatment;
	Book b;

	public Bag(String color, String brand, double price, int noOfCompatment) {
		this.color = color;
		this.brand = brand;
		this.price = price;
		this.noOfCompatment = noOfCompatment;
	}

	public void addBook(String name, double price, String author) {
		b = new Book(name, price, author);
		System.out.println("new Book Created");
	}

	public void getBagDetails() {
		System.out.println("Color: " + color);
		System.out.println("Brand: " + brand);
		System.out.println("Price: " + price);
		System.out.println("Compatments: " + noOfCompatment);
	}

	public void removeBook() {
		if (b != null) {
			b = null;
			System.out.println("book removed");
		} else {
			System.out.println("bag is empty");
		}
	}
}
