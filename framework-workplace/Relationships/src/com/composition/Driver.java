package com.composition;

public class Driver {
	public static void main(String[] args) {
		Car car = new Car(101, "swift", "suzuki", "white", 700000);
		car.getCarDetails();
		car.e.getEngDetails();
	}
}
