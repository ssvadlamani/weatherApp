package com.bookinghawk.weatherapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookinghawk.weatherapp.response.JsonResponse;
import com.bookinghawk.weatherapp.util.Utils;

@ControllerAdvice(basePackages="com.bookinghawk.weatherapp")
public class WeatherExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { CityNotFoundException.class, IllegalArgumentException.class })
	protected ResponseEntity<Object> handleConflict(IllegalArgumentException ex, WebRequest request) {
		JsonResponse response = Utils.buildResponse(null, "404","CITI NOT FOUND!, PLEASE CHECK SPELLING!");
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}