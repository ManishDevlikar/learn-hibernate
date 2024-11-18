package one_to_one_bi.dt;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Os {

	@Id
	private int id;
	private int bit;
	private String type;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "os")
	private Laptop laptop;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBit() {
		return bit;
	}

	public void setBit(int bit) {
		this.bit = bit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

//	@Override
//	public String toString() {
//		return "Os [id=" + id + ", bit=" + bit + ", type=" + type + "laptop=" + laptop;
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Os Id:" + getId() + "Os Bit:" + getBit() + "Os type:" + getType());
		if (laptop != null) {
			sb.append("Laptop Id:" + laptop.getId() + "Laptop Brand:" + laptop.getBrand() + "laptop Color:"
					+ laptop.getColor() + "Laptop price" + laptop.getPrice());
		}

		return sb.toString();
	}
}
