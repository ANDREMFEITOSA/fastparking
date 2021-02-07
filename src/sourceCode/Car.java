package sourceCode;

import java.math.BigDecimal;

public class Car {
	private BigDecimal width;
	private BigDecimal length;
	
	public Car (String vin) {
		CarDimensionsResearch specifications = new CarDimensionsResearch();
		specifications.request(vin);
		
		width = specifications.getWidth();
		length = specifications.getLength();
	}
	
	public BigDecimal getWidth() {
		return this.width;
	}
	
	public BigDecimal getLength() {
		return this.length;
	}
}
