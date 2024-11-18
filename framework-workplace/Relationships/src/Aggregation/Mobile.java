package Aggregation;

public class Mobile {
	int imei;
	String brand;
	String model;
	double price;
	Sim s;

	public Mobile(int imei, String brand, String model, double price) {

		this.imei = imei;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public Sim insertSim(Sim s) {
		return this.s = s;
	}

	public void getMobileDetails() {
		System.out.println(imei);
		System.out.println(brand);
		System.out.println(model);
		System.out.println(price);
		s.getSimDetals();
	}

	public void insertSim1(String provider, String type) {
		s = new Sim(provider, type);

	}

}
