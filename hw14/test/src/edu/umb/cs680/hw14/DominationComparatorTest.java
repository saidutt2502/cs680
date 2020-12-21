package src.edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.Car;





class DominationComparatorTest {

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
		for(int i=0 ; i<cars.size() ; i++) {
			cars.get(i).setDominationCount(i);
		}
		Collections.sort(cars,(Car arg0, Car arg1) -> arg1.getDominationCount()-arg0.getDominationCount());
	}
	
	@Test
	void testforcar1() {
		assertSame(3, cars.get(0).getDominationCount());
	}
	
	@Test
	void testforcar2() {
		assertSame(2, cars.get(1).getDominationCount());
	}
	
	@Test
	void testforcar3() {
		assertSame(1, cars.get(2).getDominationCount());
	}
	
	
	
	
	@Test
	void testforcar4() {
		assertSame(0, cars.get(3).getDominationCount());
	}
	
	

}
