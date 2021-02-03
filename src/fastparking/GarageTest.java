package fastparking;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GarageTest {

	@Test
	void priceTest() {
		Garage garage = new Garage("location", "name");
		
		for(int i = 0; i < 10; i++) {
			garage.newSearch();
		}
		BigDecimal price = new BigDecimal("5");
		
		Assertions.assertEquals("gold", garage.getStatus());
		Assertions.assertEquals(price, garage.getPrice());
		
		for(int i = 0; i < 160; i++) {
			garage.newSearch();
		}
		price = new BigDecimal("10");
		
		Assertions.assertEquals("platinum", garage.getStatus());
		Assertions.assertEquals(price, garage.getPrice());
		
		for(int i = 0; i < 80; i++) {
			garage.newSearch();
		}
		price = new BigDecimal("20");
		
		Assertions.assertEquals("black", garage.getStatus());
		Assertions.assertEquals(price, garage.getPrice());
	}
	
}
