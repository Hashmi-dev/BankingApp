package com.hashmi.bankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BankingAppApplication {
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	public static void main(String[] args) {

		SpringApplication.run(BankingAppApplication.class, args);
	}

}
