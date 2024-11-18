package one_to_many_uni_assi_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class College {
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", location=" + location + ", rating=" + rating
				+ ", fieldOfStudy=" + fieldOfStudy + "]";
	}

	@Id
	private int id;
	private String name;
	private String location;
	private double rating;
	private String fieldOfStudy;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
}
