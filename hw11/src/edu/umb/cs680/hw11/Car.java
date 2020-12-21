package edu.umb.cs680.hw11;

public class Car {
	
	private String make, model;
	private int mileage, year;
	private float price;
	private int dominationCount;
	
	public Car(String make, String model, int year, int mileage, float price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
	}
	
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public int getMileage() {
		return mileage;
	}
	public int getYear() {
		return year;
	}
	public float getPrice() {
		return price;
	} 
	
	public int getDominationCount() {
		return dominationCount;
	}
	
	public void setDominationCount(int dominationCount) {
		this.dominationCount = dominationCount;
	}
	
	@Override
	public boolean equals(Object obj) {
		Car c = (Car) obj;
		if(make.equals(c.getMake()) 
				&& model.equals(c.getModel()) 
				&& year==c.getYear()
				&& mileage==c.getMileage()
				&& price==c.getPrice() 
				&& dominationCount==c.getDominationCount())
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Car Works");
	}
}
