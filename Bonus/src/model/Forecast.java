package model;

import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import repository.ForecastType;


@Entity
public class Forecast {

    private Integer day;
    private Long trianglePerimeter;
    private ForecastType weather;
    
    public Forecast(int day) {
    	this.day = day;
    }

	public int getDay() {
	    return this.day;
	}
	
	public void setTrianglePerimeter(long perimeter) {
		this.trianglePerimeter = perimeter;
	}
	
	public long getTrianglePerimieter() {
		return this.trianglePerimeter;
	}
	
	public ForecastType getWeather() {
	    return this.weather;
	}
	
	public void setWeather(ForecastType weather) {
		this.weather = weather;
	}
}
