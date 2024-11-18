package one_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport {
	@Override
	public String toString() {
		return "Passport [pId=" + pId + ", origine=" + origine + ", date_Of_Issue=" + date_Of_Issue + "]";
	}

	@Id
	private int pId;
	private String origine;
	private String date_Of_Issue;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getDate_Of_Issue() {
		return date_Of_Issue;
	}

	public void setDate_Of_Issue(String date_Of_Issue) {
		this.date_Of_Issue = date_Of_Issue;
	}
}
