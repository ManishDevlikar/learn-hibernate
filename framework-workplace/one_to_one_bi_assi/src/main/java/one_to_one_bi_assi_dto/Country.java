package one_to_one_bi_assi_dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Country {
	@Id
	private int id;
	private String population;
	private String capital;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private President president;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public President getPresident() {
		return president;
	}

	public void setPresident(President president) {
		this.president = president;
	}

//	@Override
//	public String toString() {
//		return "Country [id=" + id + ", population=" + population + ", capital=" + capital + ", name=" + name
//				+ ", president=" + president + "]";
//	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", population=" + population + ", capital=" + capital + ", name=" + name
				+ ", presidentname=" + president.getName() + ", president Id=" + president.getId() + ", president Age="
				+ president.getAge() + "]";
	}
}
