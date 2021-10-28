import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

public class mychatBotTest {
	private OWM owm;

	@Test
	public void owmKeyTest1() {
		/*
		 * Description: This is the test method for ovmKey method Tests the expected
		 * value with the actual value of the ovmKey value.
		 */
		// actual api key
		String actual = Weather.owmKey();
		// expected api key
		String expected = "d0f32b9c23414ea98139dc75c49300c6";
		// assert equals check if actual expected is equals
		assertEquals(expected, actual);
	}
	
	@Test
	public void owmKeyTest2() {
		/*
		 * Description: This is the test method for ovmKey method Tests the expected
		 * value with the actual value of the ovmKey value.
		 */
		// actual api key
		String actual = Weather.owmKey();
		// expected api key
		String expected = "d403498394382993c00";
		// assert equals check if actual expected is equals
		assertNotEquals(expected, actual);
	}
	
	@Test
	public void owmKeyTest3() {
		/*
		 * Description: This is the test method for ovmKey method Tests the expected
		 * value with the actual value of the ovmKey value.
		 */
		// actual api key
		String actual = Weather.owmKey();
		// expected api key
		//String expected = "d403498394382993c00";
		// assert equals check if actual expected is equals
		assertNotNull(actual);
	}

	@Test
	public void Test1GetCity() {
		/*
		 * Description: This is the first test method for getCity method Tests the
		 * expected value with the actual value of the getCity value.
		 */
		String city = "Lahore";
		// actual value
		boolean actual = Weather.getCity(city);
		// passed parameter must not be null
		assertNotNull(actual);
	}
	
	@Test
	public void Test2GetCity() {
		
		String city = "karachi";
		// actual value
		boolean actual = Weather.getCity(city);
		// checking if the city exist
		assert(actual);
	}
	
	@Test
	public void Test3GetCity() {
		
		String city = "dubai";
		// actual value
		boolean actual = Weather.getCity(city);
		// checking if the city exist
		assertNotNull(actual);
	}
	
	@Test
	public void Test4GetCity() {
		
		String city = "duubai";
		
		boolean expected = Weather.getCity("dubai");
		// actual value
		boolean actual = Weather.getCity(city);
		// checking if the city exist
		assertNotEquals(expected, actual);
	}
}
