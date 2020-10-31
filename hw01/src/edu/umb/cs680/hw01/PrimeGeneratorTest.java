package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	public void primeNumbersBetween10and20() {
		PrimeGenerator gen = new PrimeGenerator(10, 20);
		gen.generatePrimes();
		Long[] expectedPrimes = {11L, 13L, 17L , 19L};
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
	}
	
	@Test
	public void primeNumbersBetweenNegative10and10() {
		try {
			PrimeGenerator gen = new PrimeGenerator(-10, 10);
			gen.generatePrimes();
			fail("Wrong input values: from=-10 to=10");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values: from=-10 to=10", e.getMessage());
		}
	}
	
	@Test
	public void primeNumbersBetween100and1() {
		try {
			PrimeGenerator gen = new PrimeGenerator(100, 1);
			gen.generatePrimes();
			fail("Wrong input values: from=100 to=1");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values: from=100 to=1", e.getMessage());
		}
	}
	
	@Test
	public void primeNumbersBetween0and0() {
		try {
			PrimeGenerator gen = new PrimeGenerator(0, 0);
			gen.generatePrimes();
			fail("Wrong input values: from=0 to=0");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values: from=0 to=0", e.getMessage());
		}
	}

}