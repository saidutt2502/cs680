package src.edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.DominationComparator;

class DominationComparatorTest {

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
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(3, carList.get(0).getDominationCount());
	}
	
	@Test
	void testforcar2() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(2, carList.get(1).getDominationCount());
	}
	
	@Test
	void testforcar3() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(1, carList.get(2).getDominationCount());
	}
	
	
	@Test
	void testforcar4() {
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(0, carList.get(3).getDominationCount());
	}
	
	

}
