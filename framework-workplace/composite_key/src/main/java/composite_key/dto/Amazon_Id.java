package composite_key.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Amazon_Id implements Serializable {
	private String email;
	private String mobNo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobNo == null) ? 0 : mobNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amazon_Id other = (Amazon_Id) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobNo == null) {
			if (other.mobNo != null)
				return false;
		} else if (!mobNo.equals(other.mobNo))
			return false;
		return true;
	}

}
