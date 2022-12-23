package com.microservicosjava.hrouath.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservicosjava.hrouath.entities.User;
import com.microservicosjava.hrouath.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;

	public User findyByEmail(String email) {
		User response = userFeignClient.findByEmail(email).getBody();
		if (response == null) {
			logger.error("email not found" + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found " + email);
		return response;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User response = userFeignClient.findByEmail(username).getBody();
		if (response == null) {
			logger.error("email not found" + username);
			throw new UsernameNotFoundException("username not found");
		}
		logger.info("Email found " + username);
		return response;
	}
}
