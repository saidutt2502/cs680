package src.edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.Car;


class YearComparatorTest {

static LinkedList<Car> cars = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car c1 = new Car("Mercedes", "C-CLass", 2019, 45000, 76000);
		Car c2 = new Car("Ford", "Mustang", 2014, 65000, 90000);
		Car c3 = new Car("Audi", "A8", 2019, 78000, 95000);
		Car c4 = new Car("BMW", "7-Series", 2020, 14000, 670000);
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		cars.add(c4);
		Collections.sort(cars,(Car arg0, Car arg1) -> arg0.getYear()-arg1.getYear());
	}
	
	
	@Test
	void testforcar1() {
		Car c1 = new Car("Mercedes", "C-CLass", 2019, 45000, 76000);
		assertEquals(c1, cars.get(3));
	}
	
	@Test
	void testforcar2() {
		Car c2 = new Car("Ford", "Mustang", 2014, 65000, 90000);
		assertEquals(c2, cars.get(2));
	}
	
	@Test
	void testforcar3() {
		Car c3 = new Car("Audi", "A8", 2019, 78000, 95000);
		assertEquals(c3, cars.get(1));
	}
	
	
	@Test
	void testforcar4() {
		Car c4 = new Car("BMW", "7-Series", 2020, 14000, 670000);
		assertEquals(c4, cars.get(0));
	}
	
	

}
