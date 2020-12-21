package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car>{

	@Override
	public int compare(Car c1, Car c2) {
		if(c2.getPrice()>=c1.getPrice() 
				&& c1.getYear()>=c2.getYear() 
				&& c2.getMileage()>=c1.getMileage()) {
			if(c2.getPrice()>c1.getPrice() 
					|| c1.getYear()>c2.getYear() 
					|| c2.getMileage()>c1.getMileage())
				return -1;
			return 0;
		}
		return 0;
	}
}
