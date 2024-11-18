package com.composition.task;

public class Person {
	int id;
	String name;
	String add;
	int iq;
	Brain b;

	public Person(int id, String name, String add, int iq, String memory, double temp, String weight) {
		this.id = id;
		this.name = name;
		this.add = add;
		this.iq = iq;
		b = new Brain(memory, temp, weight);
	}

	public void getPersonDetails() {
		System.out.println("id: " + this.id + " \n" + "name: " + this.name + "\n " + "Add: " + this.add + "\n " + "iq: "
				+ this.iq);
	}

}
