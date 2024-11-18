package one_to_many_bi_assi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {
	@Id
	private int id;
	private String cm;
	private long population;
	private String capital;
	private String dateOfFormation;
	private String name;

	@Override
	public String toString() {
		return "State [id=" + id + ", cm=" + cm + ", population=" + population + ", capital=" + capital
				+ ", dateOfFormation=" + dateOfFormation + ", cities=" + cities + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getDateOfFormation() {
		return dateOfFormation;
	}

	public void setDateOfFormation(String dateOfFormation) {
		this.dateOfFormation = dateOfFormation;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
	private List<City> cities;
}
