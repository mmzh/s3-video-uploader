package com.vm.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class UserProfile {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int p_id;	

	@Column(name="p_type", length=15, unique=true, nullable=false)
	private String p_type = UserProfileType.ADMIN.getUserProfileType();
	
	public int getId() {
		return p_id;
	}

	public void setId(int id) {
		this.p_id = id;
	}

	public String getType() {
		return p_type;
	}

	public void setType(String type) {
		this.p_type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + p_id;
		result = prime * result + ((p_type == null) ? 0 : p_type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserProfile))
			return false;
		UserProfile other = (UserProfile) obj;
		if (p_id != other.p_id)
			return false;
		if (p_type == null) {
			if (other.p_type != null)
				return false;
		} else if (!p_type.equals(other.p_type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + p_id + ",  type=" + p_type	+ "]";
	}
	

}
