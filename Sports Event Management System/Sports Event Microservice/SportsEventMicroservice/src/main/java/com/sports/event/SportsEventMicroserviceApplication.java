package com.sports.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sports.event.entity.Events;
import com.sports.event.entity.Sports;

@SpringBootApplication
public class SportsEventMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsEventMicroserviceApplication.class, args);
	}
	
	@Bean
	public Sports sports() {
		return new Sports();

	}

	@Bean
	public Events events() {
		return new Events();

	}

}
