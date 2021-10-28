import java.util.Random;


import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

public class Weather {
	
	
	
	// method to test the API key
	public static String owmKey() {
		return "d0f32b9c23414ea98139dc75c49300c6"; // api key
	}

	static CurrentWeather cwd;

		
	public static Boolean getCity(String city) {
		/*
		 * Description: This method returns the name of the city available and valid.
		 
		 * @return : return the back the name of the city if valid.
		 */

		// declaring object of "OWM" class
		OWM owm = new OWM(owmKey());

		// getting current weather data for the selected city

		try {
			cwd = owm.currentWeatherByCityName(city);
			if (cwd.hasCityId()) {
				// we then return the city name
				return true;

			}

		} catch (APIException e) {
			// returns if city doesn't exist on the OWM API
			return false;
		}
		return null; // else return null
	}
	
	// method for getting the max temperature.
	public double getTempMax() {
		// getting the max temperature for any city
	    return cwd.getMainData().getTempMax() - 273.15;
	}
	
		// declaring strings for low, mid and high temperatures.
		String low = "woolen clothes, jacket, scarf";
		String mid = "shirts, sweater, jeans";
		String high = "trousers, sunglasses, shorts";
		
}

