package one_to_many_bi_dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Library {
	@Id
	private int id;

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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	private String name;
	private String place;
	private long phoneNo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "library")
	private List<Books> books;

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", place=" + place + ", phoneNo=" + phoneNo + ", books=" + books
				+ "]";
	}
}
