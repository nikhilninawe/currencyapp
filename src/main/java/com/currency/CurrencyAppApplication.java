package com.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.currency.config"})
public class CurrencyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyAppApplication.class, args);
	}
}
