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

/**
 * Model layer of User
 * 
 * @author ming
 * @version 1.0.0
 */
@Entity
@Table(name = "users")
public class User {

	/**
	 * user id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int u_id;

	/**
	 * user name
	 */
	@NotEmpty
	@Column(name = "u_name", unique = true, nullable = false)
	private String u_name;

	/**
	 * user password
	 */
	@NotEmpty
	@Column(name = "u_password", nullable = false)
	private String u_password;

	/**
	 * user profile set
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_profile_map", joinColumns = { @JoinColumn(name = "u_id") }, inverseJoinColumns = {
			@JoinColumn(name = "p_id") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

	/**
	 * get user id
	 * 
	 * @return id
	 */
	public int getId() {
		return u_id;
	}

	/**
	 * set id
	 * 
	 * @param id
	 *            user id
	 */
	public void setId(int id) {
		this.u_id = id;
	}

	/**
	 * get user name
	 * 
	 * @return String user name
	 */
	public String getUsername() {
		return u_name;
	}

	/**
	 * set user name
	 * 
	 * @param username
	 *            user name
	 */
	public void setUsername(String username) {
		this.u_name = username;
	}

	/**
	 * get password
	 * 
	 * @return String password
	 */
	public String getPassword() {
		return u_password;
	}

	/**
	 * set password
	 * 
	 * @param password
	 *            String
	 */
	public void setPassword(String password) {
		this.u_password = password;
	}

	/**
	 * get list of user Profiles
	 * 
	 * @return UserProfile Set
	 */
	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	/**
	 * set userProfiles
	 * 
	 * @param userProfiles
	 *            user profile object
	 */
	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + u_id;
		result = prime * result + ((u_name == null) ? 0 : u_name.hashCode());
		return result;
	}

	/**
	 * over ride Object.equals function
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
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

	/**
	 * override toString method
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "User [id=" + u_id + ", username=" + u_name + ", password=" + u_password + ", userProfiles="
				+ userProfiles + "]";
	}

}
