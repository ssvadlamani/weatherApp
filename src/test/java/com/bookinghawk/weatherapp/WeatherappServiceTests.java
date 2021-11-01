package com.bookinghawk.weatherapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookinghawk.weatherapp.response.JsonError;
import com.bookinghawk.weatherapp.response.JsonResponse;
import com.bookinghawk.weatherapp.service.WeatherService;
import com.bookinghawk.weatherapp.vo.WeatherDTO;

@SpringBootTest
class WeatherappServiceTests {

	@Autowired
	private WeatherService weatherService;

	@Test
	@Disabled
	void test_getWeather() {
		String location = "berlin";
		JsonResponse response = weatherService.getWeather(location);
		WeatherDTO weatherDTO = (WeatherDTO) response.getData();

		assertEquals("berlin", weatherDTO.getName());
		assertNotNull(response.getData());
	}
	
	
	@Test
	@Disabled
	void test_getWeatherError() {
		String location = "berlin";
		JsonResponse response = weatherService.getWeather(location);
		JsonError error= response.getError();
		
	    assertEquals("503",error.getErrorCode());
	    assertNotNull(response.getError());
	}

}
