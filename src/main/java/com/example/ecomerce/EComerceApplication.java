package com.example.ecomerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class EComerceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EComerceApplication.class, args);
	}

}
