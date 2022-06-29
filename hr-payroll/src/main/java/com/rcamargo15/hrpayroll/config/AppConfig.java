package com.rcamargo15.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() { //instancia de objeto restTemplate para injetar no projeto inteiro
		return new RestTemplate();
	}
}
