package fastparking;

import java.math.BigDecimal;

public class Car {
	private String licensePlate;
	private String document;
	private String model;
	private BigDecimal width;
	private BigDecimal length;
	
	public void setCarDimensions(String vin) {
		CarDimensionsResearch specifications = new CarDimensionsResearch();
		specifications.request(vin);
		
		width = specifications.getWidth();
		length = specifications.getLength();
	}
}
