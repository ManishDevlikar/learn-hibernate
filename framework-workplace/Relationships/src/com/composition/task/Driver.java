package com.composition.task;

public class Driver {

	public static void main(String[] args) {
		Person p = new Person(101, "manish", "thane", 150, "2.5 million gigabytes", 38.5, "1.4 kg");
		p.getPersonDetails();
		p.b.getBrainDetails();
	}

}
