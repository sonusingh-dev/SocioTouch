package com.socioffice.sociotouch.weather;


/**
 * Combines one WeatherCurrentCondition with a List of
 * WeatherForecastConditions.
 */
public class WeatherSet {

	private String temperature = null;
    
    public String getTemperature() {
            return temperature;
    }
    public void setTemperature(String temperature) {
            this.temperature = temperature;
    }
    
}
