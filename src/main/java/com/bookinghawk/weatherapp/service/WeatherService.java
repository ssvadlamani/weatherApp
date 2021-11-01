package com.bookinghawk.weatherapp.service;

import com.bookinghawk.weatherapp.response.JsonResponse;

public interface WeatherService {
	
	JsonResponse getWeather(String location);
		

}
