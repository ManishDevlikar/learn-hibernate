package Aggregation;

public class Sim {
	String provider;
	String type;

	public Sim(String provider, String type) {

		this.provider = provider;
		this.type = type;
	}

	public void getSimDetals() {
		System.out.println(provider);
		System.out.println(type);
	}
}
