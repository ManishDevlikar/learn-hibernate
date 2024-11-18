package one_to_one_bi_assi_dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class President {
	@Id
	private int id;
	private String name;
	private int age;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "president")
	private Country country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "President [id=" + id + ", name=" + name + ", age=" + age + ", countryName=" + country.getName()
				+ ", country Id=" + country.getId() + ", country Population=" + country.getPopulation()
				+ ", country Capital=" + country.getCapital() + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return "President [id=" + id + ", name=" + name + ", age=" + age + ", country=" + country + "]";
//	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
