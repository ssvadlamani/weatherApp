package com.bookinghawk.weatherapp.vo;

import java.io.Serializable;
import java.util.List;

public class WeatherDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public WeatherDTO() {
		
	}
	
	public WeatherDTO(String name, Main main, List<Weather> weather) {
		this.name = name;
		this.main = main;
		this.weather = weather;
	}
	private String name;
	private Main main;
	private List<Weather> weather;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	

}
