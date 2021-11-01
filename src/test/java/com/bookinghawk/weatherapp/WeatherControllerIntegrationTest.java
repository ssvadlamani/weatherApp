package com.bookinghawk.weatherapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bookinghawk.weatherapp.response.JsonError;
import com.bookinghawk.weatherapp.response.JsonResponse;
import com.bookinghawk.weatherapp.vo.WeatherDTO;


@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WeatherControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    
    //WeatherService calling live weather third party service. we can handle using mockito. 
    @Test
    @Disabled
    public void test_getWeatherIntegration()
    {
    	HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		ResponseEntity<JsonResponse> response= this.restTemplate.getForEntity("http://localhost:" + port + "/weather/berlin",JsonResponse.class);
		WeatherDTO weatherDTO = (WeatherDTO)response.getBody().getData();
		
		System.out.println((WeatherDTO)response.getBody().getData());
    	
    assertEquals("berlin",weatherDTO.getName());
    assertNotNull(response.getBody().getData());
    
    }

    
    @Test
    @Disabled
    public void test_getWeatherIntegrationError()
    {
    	HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		ResponseEntity<JsonResponse> response= this.restTemplate.getForEntity("http://localhost:" + port + "/weather/berlin",JsonResponse.class);
		JsonError error= response.getBody().getError();
		
    assertEquals("404",error.getErrorCode());
    assertNotNull(response.getBody().getError());
    
    }
    
}

