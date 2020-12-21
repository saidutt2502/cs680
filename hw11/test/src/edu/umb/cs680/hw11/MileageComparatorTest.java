package src.edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.MileageComparator;

class MileageComparatorTest {

	static LinkedList<Car> carList = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car c1 = new Car("Mercedes", "C-CLass", 2019, 45000, 76000);
		Car c2 = new Car("Ford", "Mustang", 2014, 65000, 90000);
		Car c3 = new Car("Audi", "A8", 2019, 78000, 95000);
		Car c4 = new Car("BMW", "7-Series", 2020, 14000, 670000);
		carList.add(c1);
		carList.add(c2);
		carList.add(c3);
		carList.add(c4);
	}
	
	
	@Test
	void testforcar1() {
		Car c1 = new Car("Mercedes", "C-CLass", 2019, 45000, 76000);
		carList.sort(new MileageComparator());
		assertEquals(c1, carList.get(0));
	}
	
	@Test
	void testforcar2() {
		Car c2 = new Car("Ford", "Mustang", 2014, 65000, 90000);
		carList.sort(new MileageComparator());
		assertEquals(c2, carList.get(1));
	}
	
	
	
	@Test
	void testforcar3() {
		Car c3 = new Car("Audi", "A8", 2019, 78000, 95000);
		carList.sort(new MileageComparator());
		assertEquals(c3, carList.get(2));
	}
	
	
	
	@Test
	void testforcar4() {
		Car c4 = new Car("BMW", "7-Series", 2020, 14000, 670000);
		carList.sort(new MileageComparator());
		assertEquals(c4, carList.get(3));
	}
	
	

}
