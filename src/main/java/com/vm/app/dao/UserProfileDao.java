package com.vm.app.dao;

import java.util.List;

import com.vm.app.model.UserProfile;

/**
 * DAO layer interface for UserProfile
 * 
 * @author ming
 * @version 1.0.0
 */
public interface UserProfileDao {

	/**
	 * get user profile
	 * 
	 * @return List format
	 */
	List<UserProfile> findAll();

	/**
	 * find user by profile type
	 * 
	 * @param type
	 *            user admin level
	 * @return UserProfile
	 */
	UserProfile findByType(String type);

	/**
	 * get user profile by id
	 * 
	 * @param id
	 *            user id
	 * @return UserProfile
	 */
	UserProfile findById(int id);
}
