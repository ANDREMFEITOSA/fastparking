package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sourceCode.*;
class GarageTest {

	@Test
	void priceTest() {
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage garage = new Garage("location", "name", CONSTANT_LENGTH, CONSTANT_LENGTH);
		
		for(int i = 0; i < 2; i++) {
			garage.newSearch();
		}
		
		BigDecimal price = new BigDecimal("5");
		
		Assertions.assertEquals("gold", garage.getStatus());
		Assertions.assertEquals(price, garage.getPrice());
		
		for(int i = 0; i < 2; i++) {
			garage.newSearch();
		}
		price = new BigDecimal("10");
		
		Assertions.assertEquals("platinum", garage.getStatus());
		Assertions.assertEquals(price, garage.getPrice());
		
		for(int i = 0; i < 3; i++) {
			garage.newSearch();
		}
		price = new BigDecimal("20");
		
		Assertions.assertEquals("black", garage.getStatus());
		Assertions.assertEquals(price, garage.getPrice());
	}
	
}
