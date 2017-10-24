package com.vm.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vm.app.model.UserProfile;

/**
 * DAO layer interface implementation for UserProfile
 * 
 * @author ming
 * @version 1.0.0
 */

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {

	/**
	 * get user profile
	 * 
	 * @return List format
	 */
	@SuppressWarnings("unchecked")
	public List<UserProfile> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("p_type"));
		return (List<UserProfile>) crit.list();
	}

	/**
	 * find user by profile id
	 * 
	 * @param id
	 *            user profile id
	 * @return UserProfile
	 */
	public UserProfile findById(int id) {
		return getByKey(id);
	}

	/**
	 * get user profile by type
	 * 
	 * @param type
	 *            user type
	 * @return UserProfile
	 */
	public UserProfile findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("p_type", type));
		return (UserProfile) crit.uniqueResult();
	}
}
