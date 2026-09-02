package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// this is a java config class
@SpringBootApplication
public class SpringBootApp1Application {
	public static void main(String[] args) {
		//initialize the spring application context and return it
		SpringApplication.run(SpringBootApp1Application.class, args);
	}

}
