package com.bag;

public class Driver {
	public static void main(String[] args) {
		Bag b = new Bag("black", "asus", 500, 4);
		b.getBagDetails();
		b.addBook("data structure in java", 150, "manish");
		b.removeBook();
	}
}
