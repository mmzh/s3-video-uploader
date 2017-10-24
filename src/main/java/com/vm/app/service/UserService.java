package com.vm.app.service;

import com.vm.app.model.User;

/**
 * user service layer
 * 
 * @author ming
 * @version 1.0.0
 */
public interface UserService {

	/**
	 * save user data
	 * 
	 * @param user
	 *            user object
	 */
	void save(User user);

	/**
	 * get user by id
	 * 
	 * @param id
	 *            user id
	 * @return user object
	 */
	User findById(int id);

	/**
	 * find user by user name
	 * 
	 * @param username
	 *            user name
	 * @return user object
	 */
	User findByUsername(String username);

}