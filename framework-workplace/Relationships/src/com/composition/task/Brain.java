package com.composition.task;

public class Brain {
	String memory;
	double temp;
	String weight;

	public Brain(String memory, double temp, String weight) {
		this.memory = memory;
		this.temp = temp;
		this.weight = weight;
	}

	public void getBrainDetails() {
		System.out.println("Memory: " + this.memory + " \n" + "Temp: " + this.temp + " \n" + " Weight: " + this.weight);
	}

}
