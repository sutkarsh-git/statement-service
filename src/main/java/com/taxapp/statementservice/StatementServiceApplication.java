package com.taxapp.statementservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatementServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StatementServiceApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello2");
	}
}
