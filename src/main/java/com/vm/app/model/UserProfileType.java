package com.vm.app.model;

/**
 * user profile type model
 * 
 * @author ming
 * @version 1.0.0
 */
public enum UserProfileType {

	ADMIN("ADMIN");

	/**
	 * user profile type
	 */
	String userProfileType;

	/**
	 * set type value
	 * 
	 * @param userProfileType
	 *            user profile type
	 */
	private UserProfileType(String userProfileType) {
		this.userProfileType = userProfileType;
	}

	/**
	 * get type value
	 * 
	 * @return String user type
	 */
	public String getUserProfileType() {
		return userProfileType;
	}

}
