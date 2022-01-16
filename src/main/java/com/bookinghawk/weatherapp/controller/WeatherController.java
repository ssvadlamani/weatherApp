package com.bookinghawk.weatherapp.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.Pathmatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookinghawk.weatherapp.response.JsonResponse;
import com.bookinghawk.weatherapp.service.WeatherService;
/**
 * 
 * @author sivasankar.v
 *
 */
@RestController
public class WeatherController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	/**
	 * 
	 * @param location
	 * @return
	 */
	@GetMapping("/weather/{location}")
	public ResponseEntity<JsonResponse> getWeather(@PathVariable("location")@Valid @NotNull(message = "Client id is mandatory")String location,Pathmatch p) {
		LOGGER.info("BEGIN GET WEATHER DETAILS FOR : "+location);
		JsonResponse response= weatherService.getWeather(location);
		LOGGER.info("END GET WEATHER DETAILS FOR : "+location);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
	
}
