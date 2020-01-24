package com.galaxyWeather.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.galaxyWeather.repository.ForecastType;

import net.minidev.json.JSONObject;

@Entity
public class Forecast {

	@Id
    private Integer day;
    private Double trianglePerimeter;
    private ForecastType weather;
    
    public Forecast() {
    }
    
    public void setDay(int day) {
    	this.day = day;
    }

	public int getDay() {
	    return this.day;
	}
	
	public ForecastType getWeather() {
	    return this.weather;
	}
	
	public void setWeather(ForecastType weather) {
		this.weather = weather;
	}
	
	public JSONObject getDayAndWeather() {
		JSONObject json = new JSONObject();
		json.appendField("día", this.day);
		json.appendField("clima", this.weather);
		return json;
	}
	
	public void setTrianglePerimeter(double perimeter) {
		this.trianglePerimeter = perimeter;
	}
	
	public double getTrianglePerimieter() {
		return this.trianglePerimeter;
	}
	

}
