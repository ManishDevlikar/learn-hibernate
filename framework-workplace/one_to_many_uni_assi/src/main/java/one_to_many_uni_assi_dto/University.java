package one_to_many_uni_assi_dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class University {
	@Id
	private int id;
	private String name;
	private String location;
	private String president;
	@OneToMany(cascade = CascadeType.ALL)
	List<College> college;

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", location=" + location + ", president=" + president
				+ ", college=" + college + "]";
	}

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

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public List<College> getCollege() {
		return college;
	}

	public void setCollege(List<College> college) {
		this.college = college;
	}

}
