package one_to_one_uni_assi.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
	@Id
	private int vehicleId;
	private String type;
	@OneToOne(cascade = CascadeType.ALL)
	VehicleNumber vehicleNumber;
	private double price;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", type=" + type + ", vehicleNumber=" + vehicleNumber + ", price="
				+ price + "]";
	}

	public VehicleNumber getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(VehicleNumber vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

}
