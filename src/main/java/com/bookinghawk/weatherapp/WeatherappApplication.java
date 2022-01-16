package com.bookinghawk.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author sivasankar.v
 *
 */
@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableCircuitBreaker
@EnableResourceServer
public class WeatherappApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(WeatherappApplication.class, args);
	}
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public WebMvcConfigurer configurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE").maxAge(3000);
			}
		};
	}


}
