package com.bookinghawk.weatherapp.util;

import com.bookinghawk.weatherapp.response.JsonError;
import com.bookinghawk.weatherapp.response.JsonResponse;

public class Utils {

	public static JsonResponse buildResponse(Object data, String errorCode, String error) {
		JsonResponse response = null;
		if (data != null) {
			response = new JsonResponse(data, null);
		} else {
			response = new JsonResponse(null, new JsonError(errorCode, error));
		}
		return response;
	}
	
}
