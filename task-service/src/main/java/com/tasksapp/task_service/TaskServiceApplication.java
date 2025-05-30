package com.tasksapp.task_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDB(){
		return args -> {
			System.out.println("***********************************************");
			System.out.println("***************	INICIANDO	*******************");
			System.out.println("***************		LA		*******************");
			System.out.println("***************	auth-service!!!	***************");
			System.out.println("***********************************************");
		};
	}
}
