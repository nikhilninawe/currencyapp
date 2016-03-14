package com.currency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.AsyncRestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.currency.controller", "com.currency.service"})
public class ApplicationConfig {
	
	@Bean
	public AsyncRestTemplate asyncRestTemplate(){
		return new AsyncRestTemplate();
	}
}
