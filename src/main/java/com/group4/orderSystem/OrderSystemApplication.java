package com.group4.orderSystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class OrderSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSystemApplication.class, args);
	}

}
