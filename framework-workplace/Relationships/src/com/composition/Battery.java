package com.composition;

public class Battery {
	int capacity;
	String substence;
	String chargeSpeed;

	public Battery(int capacity, String substence, String chargeSpeed) {
		this.capacity = capacity;
		this.substence = substence;
		this.chargeSpeed = chargeSpeed;
	}

	public void getBatteryDetails() {
		System.out.println(
				"Capacity:" + this.capacity + "substence:" + this.substence + "chargerSpeed:" + this.chargeSpeed);
	}

}
