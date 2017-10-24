package com.vm.app.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <h1>manually generate encoded password using bcrypt</h1>
 * 
 * @author Ming M Zheng
 * @version 1.0
 * @since 2017-10-21
 */
public class genBcryptPass {

	/**
	 * test manually generate bcrypt encoded password
	 * 
	 * @param args
	 *            no arg
	 */
	public static void main(String[] args) {
		String password = "yourpwd";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(password));
	}

}
