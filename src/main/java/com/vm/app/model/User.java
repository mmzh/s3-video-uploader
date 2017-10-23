package com.vm.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int u_id;

	@NotEmpty
	@Column(name="u_name", unique=true, nullable=false)
	private String u_name;
	
	@NotEmpty
	@Column(name="u_password", nullable=false)
	private String u_password;
		


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_profile_map", 
             joinColumns = { @JoinColumn(name = "u_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "p_id") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

	public int getId() {
		return u_id;
	}

	public void setId(int id) {
		this.u_id = id;
	}

	public String getUsername() {
		return u_name;
	}

	public void setUsername(String username) {
		this.u_name = username;
	}

	public String getPassword() {
		return u_password;
	}

	public void setPassword(String password) {
		this.u_password = password;
	}


	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + u_id;
		result = prime * result + ((u_name == null) ? 0 : u_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (u_id != other.u_id)
			return false;
		if (u_name == null) {
			if (other.u_name != null)
				return false;
		} else if (!u_name.equals(other.u_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + u_id + ", username=" + u_name + ", password=" + u_password + ", userProfiles=" + userProfiles +"]";
	}

	
}
