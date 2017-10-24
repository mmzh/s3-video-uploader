package com.vm.app.dao;

import com.vm.app.model.User;

/**
 * DAO layer interface for User
 *
 * @author ming
 * @version 1.0.0
 */
public interface UserDao {
	/**
	 * save user in database
	 * 
	 * @param user
	 *            user object
	 */
	void save(User user);

	/**
	 * find user by id
	 * 
	 * @param id
	 *            user id
	 * @return User object
	 */
	User findById(int id);

	/**
	 * find user by name
	 * 
	 * @param username
	 *            user name
	 * @return User object
	 */
	User findByUsername(String username);

}
