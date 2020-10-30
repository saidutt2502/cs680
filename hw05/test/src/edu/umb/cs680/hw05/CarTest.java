package src.edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Car;

class CarTest {

	private String[] carToStringArray(Car car) {
		String[] carString = { car.getMake(), car.getModel(), String.valueOf(car.getYear()) };
		return carString;
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		Car actual = new Car("BMW", "7 Series", 10, 2020, 200000);
		String[] expected = { "BMW", "7 Series", "2020" };
		assertArrayEquals(expected, carToStringArray(actual));
	}
}
