package com.RCamargo15.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RCamargo15.hroauth.entitiesDTO.UserDTO;
import com.RCamargo15.hroauth.services.UserServiceDTO;

@RestController
@RequestMapping(value = "/users")
public class UserDTOResource {

	@Autowired
	private UserServiceDTO service;
	
	@GetMapping(value = "/search")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
		try {
			UserDTO user = service.findByEmail(email);
			return ResponseEntity.ok(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
