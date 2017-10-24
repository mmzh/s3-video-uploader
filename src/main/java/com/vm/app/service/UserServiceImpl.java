package com.vm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vm.app.dao.UserDao;
import com.vm.app.model.User;

/**
 * Implementation of user service layer
 * 
 * @author ming
 * @version 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * user dao layer
	 */
	@Autowired
	private UserDao dao;

	/**
	 * password encoder
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * save user info
	 * 
	 * @param user
	 *            user object
	 */
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	/**
	 * get user by id
	 * 
	 * @param id
	 *            user id
	 * @return user object
	 */
	public User findById(int id) {
		return dao.findById(id);
	}

	/**
	 * find user by user name
	 * 
	 * @param username
	 *            user name
	 * @return user object
	 */
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

}
