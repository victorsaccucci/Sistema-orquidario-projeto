package com.victorsaccucci.Sistemaorquidarioprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SistemaOrquidarioProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaOrquidarioProjetoApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/search").allowedOrigins("http://localhost:8080");
			}
		};
	}

}
