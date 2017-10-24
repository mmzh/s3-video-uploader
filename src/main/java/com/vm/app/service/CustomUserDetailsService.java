package com.vm.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vm.app.model.User;
import com.vm.app.model.UserProfile;

/**
 * custom user detail service layer
 * 
 * @author ming
 * @version 1.0.0
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	/**
	 * userService object
	 */
	@Autowired
	private UserService userService;

	/**
	 * 
	 * load user by user name
	 * 
	 * @param username
	 *            user name
	 * @return user details
	 */
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
				true, true, true, getGrantedAuthorities(user));
	}

	/**
	 * 
	 * @param user
	 *            user object
	 * @return granted user detail
	 */
	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserProfile userProfile : user.getUserProfiles()) {

			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}

		return authorities;
	}

}
