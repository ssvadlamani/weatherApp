package com.bookinghawk.weatherapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookinghawk.weatherapp.exception.CityNotFoundException;
import com.bookinghawk.weatherapp.response.JsonError;
import com.bookinghawk.weatherapp.response.JsonResponse;
import com.bookinghawk.weatherapp.util.Utils;
import com.bookinghawk.weatherapp.vo.WeatherDTO;
import com.google.common.util.concurrent.ExecutionError;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);
	@Value("${spring.app.custom.secure.apikey}")
	private String API_KEY;

	@Value("${spring.app.thirdparty.api.url}")
	private String URL;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "getWeather_fallback")
	public JsonResponse getWeather(String location) {
		LOGGER.info("BEGIN THIRD PARTY API CALLING.");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity<WeatherDTO> weatherDTO = null;
		try {
			weatherDTO = restTemplate.exchange(URL + location + "&units=metric&appid=" + API_KEY, HttpMethod.GET,
					new HttpEntity(headers), WeatherDTO.class);
		} catch (Exception e) {
			throw new CityNotFoundException();
		}
		LOGGER.info("END THIRD PARTY API CALLING.");
		return Utils.buildResponse(weatherDTO.getBody(), null, null);
	}

	@SuppressWarnings("unused")
	private JsonResponse getWeather_fallback(String location, Throwable e) {
		try {
			Integer.parseInt(location);
			return Utils.buildResponse(null, "503","Please priovde valid city name!");
		} catch (Exception ex) {
			LOGGER.info("WEATHER API SERVICE SEEMS DOWN!!! FALLBACK ROUTE ENABLED.." + e.getMessage());
			return Utils.buildResponse(null, "503",
					"CIRCUIT BREAKER ENABLED!!! No Response From Weather API Service at this moment. Service will be back shortly!");
		}
	}

}
