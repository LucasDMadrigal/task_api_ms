package com.tasksapp.user_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner initDB(){
		return args -> {
			System.out.println("***********************************************");
			System.out.println("***************	INICIANDO	*******************");
			System.out.println("***************		LA		*******************");
			System.out.println("***************	user-service!!!		*******************");
			System.out.println("***********************************************");
		};
	}

}
