package one_to_many_uni_dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FlipKart {
	@Override
	public String toString() {
		return "FlipKart [id=" + id + ", email=" + email + ", mno=" + mno + ", gst=" + gst + ", address=" + address
				+ ", list=" + list + "]";
	}

	@Id
	private int id;
	private String email;
	private String mno;
	private String gst;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Items> getList() {
		return list;
	}

	public void setList(List<Items> list) {
		this.list = list;
	}

	private String address;

	@OneToMany(cascade = CascadeType.ALL)

	private List<Items> list;
}
