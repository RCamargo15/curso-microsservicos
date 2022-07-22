package com.RCamargo15.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RCamargo15.hroauth.entitiesDTO.UserDTO;
import com.RCamargo15.hroauth.feignclients.UserFeignClient;

@Service
public class UserServiceDTO {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	private static Logger log = LoggerFactory.getLogger(UserServiceDTO.class);
	
	public UserDTO findByEmail(String email) {
		UserDTO user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			log.error("Email not found: " + email);
			throw new IllegalArgumentException("User not found by this e-mail");
		}
		log.info("User found: " + email);
		return user;
	}
}