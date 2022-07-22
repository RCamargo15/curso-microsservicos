package com.RCamargo15.hruser;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.RCamargo15.hruser.entities.Role;
import com.RCamargo15.hruser.entities.User;
import com.RCamargo15.hruser.repositories.RoleRepository;
import com.RCamargo15.hruser.repositories.UserRepository;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleRepository repo1;

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Rafael", "rafael.camargo384@gmail.com", "j9A0I7!#z8&o9j@2T&uYn9*3@WQFn7");
		User u2 = new User(null, "Edilaine", "edilaineoliveira@gmail.com", "4u%mnFSJwP5u4jd6BZF3Z6&IGj7WSK");
		repo.saveAll(Arrays.asList(u1,u2));
		Role r1 = new Role(null, "ROLE_OPERATOR");
		Role r2 = new Role(null, "ROLE_ADMIN");
		repo1.saveAll(Arrays.asList(r1,r2));
		
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		u2.getRoles().add(r1);
		repo.saveAll(Arrays.asList(u1,u2));
		
	}
}