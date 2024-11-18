package com.company.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Company {
	@Id
	private int id;
	private String name;
	private String email;
	
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "company")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
	private List<Employee> employees;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
	
	private List<Computer> computers;



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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	public List<Computer> getComputers() {
		return computers;
	}



	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}



	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email ;
	}
	
	
}
