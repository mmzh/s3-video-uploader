package com.vm.app.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vm.app.model.User;

/**
 * Implementation of user DAO interface
 * 
 * @author ming
 * @version 1.0.0
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	/**
	 * save user info
	 * 
	 * @param user
	 *           user  object
	 */
	public void save(User user) {
		persist(user);
	}

	/**
	 * find user by id
	 * 
	 * @param id user id
	 * @return User user object
	 */
	public User findById(int id) {
		return getByKey(id);
	}

	/**
	 * find user by name
	 * 
	 * @param username user name
	 * @return User user object
	 */
	public User findByUsername(String username) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("u_name", username));
		return (User) crit.uniqueResult();
	}

}
