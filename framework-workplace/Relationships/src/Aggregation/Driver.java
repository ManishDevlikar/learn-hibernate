package Aggregation;

public class Driver {
	public static void main(String[] args) {
		Mobile m = new Mobile(1234, "Samsung", "s23", 132990.0);
		Sim s = m.insertSim(new Sim("vi", "5g"));
//		m.getMobileDetails();
		m.insertSim1("vi", "5g");
	}
}
