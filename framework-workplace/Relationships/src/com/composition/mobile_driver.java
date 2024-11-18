package com.composition;

public class mobile_driver {

	public static void main(String[] args) {
		Mobile b = new Mobile(1, "iphone 15pro max", "Apple", false, new Battery(4000, "li-Ion", "45 wolt"));
		b.getMobileDetails();
	}

}
