package com.gerador_senhas.api_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan("com.gerador_senhas.models")
public class ApiRestApplication implements WebMvcConfigurer{
	
	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

}
