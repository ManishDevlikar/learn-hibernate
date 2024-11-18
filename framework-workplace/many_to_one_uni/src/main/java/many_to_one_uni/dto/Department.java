package many_to_one_uni.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Department {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private long phoneNo;
	private String email;

	@ManyToOne(cascade = CascadeType.ALL)
	Employee employee;

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + " ]";
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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
