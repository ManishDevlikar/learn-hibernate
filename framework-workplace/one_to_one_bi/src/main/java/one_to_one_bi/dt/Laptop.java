package one_to_one_bi.dt;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Laptop {

	@Id
	private int id;
	private String brand;
	private double price;
	private String color;
	@OneToOne(cascade = CascadeType.ALL)

	@JoinColumn
	private Os os;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Os getOs() {

		return os;
	}

	public void setOs(Os os) {
		this.os = os;
	}

//	@Override
//	public String toString() {
//		return "Laptop [id=" + id + ", brand=" + brand + ", price=" + price + ", color=" + color + ", os=" + os + "]";
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:" + id + "Brand:" + brand + "Price:" + price + "Color:" + color);
		if (os != null) {
			sb.append("OS Id:" + os.getId() + "Os Bit:" + os.getBit() + "Os Type:" + os.getType());
		}

		return sb.toString();
	}
}
