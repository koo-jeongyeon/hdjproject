package com.example.hdjproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HdjprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdjprojectApplication.class, args);
	}

}
