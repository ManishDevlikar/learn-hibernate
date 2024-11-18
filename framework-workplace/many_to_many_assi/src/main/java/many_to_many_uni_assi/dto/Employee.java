package many_to_many_uni_assi.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private int yearsOfExperiance;
	private String position;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearsOfExperiance() {
		return yearsOfExperiance;
	}

	public void setYearsOfExperiance(int yearsOfExperiance) {
		this.yearsOfExperiance = yearsOfExperiance;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", yearsOfExperiance=" + yearsOfExperiance + ", position="
				+ position + "]";
	}

}
