package edu.umb.cs680.hw11;

import java.util.Comparator;

public class DominationComparator implements Comparator<Car>{

	@Override
	public int compare(Car c1, Car c2) {
		return c2.getDominationCount() - c1.getDominationCount();
	}
}
