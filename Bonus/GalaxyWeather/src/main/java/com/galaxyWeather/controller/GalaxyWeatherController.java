package com.galaxyWeather.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.galaxyWeather.domain.Forecast;
import com.galaxyWeather.repository.ForecastRepository;
import com.galaxyWeather.repository.ForecastType;

import net.minidev.json.JSONObject;

@RestController
public class GalaxyWeatherController {
	
	@Autowired
	private ForecastRepository repository;
    
	
	/* Returns the weather of certain day number.
	 * @param: day number
	 */
    @RequestMapping(value = "/clima", method = RequestMethod.GET)
	public JSONObject getWeatherByDay(@RequestParam(value="dia")String day) {
		try{
           int dayNumber = Integer.valueOf(day).intValue();
           return repository.findByDay(dayNumber).getDayAndWeather();         
	    }catch (Exception exception){
	       String message = "There is no valid forecast for that date or there was an internal error.";
	       throw new ResponseStatusException(HttpStatus.NOT_FOUND, message, exception);
	    }
	}
    
    /* 
   	 * Returns all the days with a specific weather.
   	 * @param: weather
   	 */
    @RequestMapping(value ="/clima/weather", method = RequestMethod.GET)
   	public JSONObject getWeathersByForecast(@RequestParam(value="weather")String weather) {
    	   try {
    		   ForecastType forecast = ForecastType.valueOf(weather);
    		   JSONObject response = new JSONObject();
      			List<Forecast> forecasts = repository.findByWeather(forecast);
      			List<JSONObject> responses = new ArrayList();
      			for (Forecast f : forecasts) {
      				responses.add(f.getDayAndWeather());
      			}
      			response.appendField(weather, responses);
                 return response;  
    	   } catch (Exception exception) {
    		   String message = "The value of the weather was not correct or there was an internal error. Pleas use one of these values:\n"
       		   		+ " - DROUGHT\n"
       		   		+ " - RAINY\n"
       		   		+ " - MAXIMUM_RAINY\n"
       		   		+ " - OPTIMUM_TEMP_AND_PRESSURE\n"
       		   		+ " - UNKNOWN";
    		   throw new ResponseStatusException(HttpStatus.NOT_FOUND, message, exception);
    	   }
    }
    
    /* 
	 * Returns the weather of all the days in 10 years.
	 */
    @RequestMapping(value ="/clima/allDays", method = RequestMethod.GET)
	public JSONObject getWeather() {
		try{
			JSONObject response = new JSONObject();
			List<Forecast> forecasts = repository.findAll();
			List<JSONObject> responses = new ArrayList();
			for (Forecast f : forecasts) {
				responses.add(f.getDayAndWeather());
			}
			response.appendField("Forecasts", responses);
           return response;         
	    }catch (Exception exception){
	    	String message = "There was an internal error. Please reload the page or contact the administrator.";
	    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, message, exception);
	    }
	}
    

}