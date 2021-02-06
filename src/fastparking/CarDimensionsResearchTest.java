package fastparking;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class CarDimensionsResearchTest {

	@Test
	void getLengthTest() {
		String vin = "JTDZN3EU0E3298500";
		CarDimensionsResearch specResearch = new CarDimensionsResearch();
		specResearch.request(vin);
		BigDecimal length = specResearch.getLength();
		
	}
	
	@Test
	void getWidthTest() {
		String vin = "JTDZN3EU0E3298500";
		CarDimensionsResearch specResearch = new CarDimensionsResearch();
		
		specResearch.request(vin);
		BigDecimal width = specResearch.getWidth();
		
		
	}

}
