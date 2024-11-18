package com.composition;

public class Mobile {
	int mobId;
	String name;
	String brand;
	boolean isFoldable;
	Battery b;

	public Mobile(int mobId, String name, String brand, boolean isFoldable, Battery b) {
		this.mobId = mobId;
		this.name = name;
		this.brand = brand;
		this.isFoldable = isFoldable;
		this.b = b;
	}

	public void getMobileDetails() {
		System.out.println("Id:" + this.mobId + "\n " + "name:" + this.name + "brand:" + this.brand + "isFoldable:"
				+ this.isFoldable);
		b.getBatteryDetails();
	}
}
