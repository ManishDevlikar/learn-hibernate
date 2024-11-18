package composite_key.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AMAZON")
public class Amazon {

	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PASSWORD")
	private String pass;

	@EmbeddedId
	private Amazon_Id id;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Amazon_Id getId() {
		return id;
	}

	public void setId(Amazon_Id id) {
		this.id = id;
	}

}
