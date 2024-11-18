package one_to_one_uni_assi.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleNumber {
	@Override
	public String toString() {
		return "VehicleNumber [id=" + id + ", owner=" + owner + ", number=" + number + ", issuedDate=" + issuedDate
				+ ", region=" + region + "]";
	}

	@Id
	private int id;
	private String owner;
	private String number;
	private String issuedDate;
	private String region;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
