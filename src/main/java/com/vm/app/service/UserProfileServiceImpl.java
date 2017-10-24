package com.vm.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vm.app.dao.UserProfileDao;
import com.vm.app.model.UserProfile;

/**
 * implementation of user profile service layer interface
 * 
 * @author ming
 * @version 1.0.0
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	/**
	 * user profile DAO
	 */
	@Autowired
	UserProfileDao dao;

	/**
	 * find all users
	 * 
	 * @return list of user profile
	 */
	public List<UserProfile> findAll() {
		return dao.findAll();
	}

	/**
	 * filter users by type
	 * 
	 * @param type
	 *            user type
	 * @return user profile
	 */
	public UserProfile findByType(String type) {
		return dao.findByType(type);
	}

	/**
	 * find user by id
	 * 
	 * @param id
	 *            user id
	 * @return user profile
	 */
	public UserProfile findById(int id) {
		return dao.findById(id);
	}
}
