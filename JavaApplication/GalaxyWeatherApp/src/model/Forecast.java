package model;

public class Forecast {

    private Integer day;
    private ForecastType weather;
    private Double trianglePerimeter;
    
    public Forecast(int day) {
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
	
	public double getPerimeter() {
	    return this.trianglePerimeter;
	}
	
	public void setPerimeter(double perimeter) {
		this.trianglePerimeter = perimeter;
	}
	
	public String toString() {
		return String.format("Día: %s, clima: %s",this.day, this.weather);
	}
}
