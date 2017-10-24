package com.vm.app.service;

import java.util.List;

import com.vm.app.model.UserProfile;

/**
 * user profile service layer interface
 * 
 * @author ming
 * @version 1.0.0
 */
public interface UserProfileService {

	/**
	 * find all users
	 * 
	 * @return list of user profile
	 */
	List<UserProfile> findAll();

	/**
	 * filter users by type
	 * 
	 * @param type
	 *            user type
	 * @return user profile
	 */
	UserProfile findByType(String type);

	/**
	 * find user by id
	 * 
	 * @param id
	 *            user id
	 * @return user profile
	 */
	UserProfile findById(int id);
}
