package fastparking;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GarageDatabaseTest {

	@Test
	void enableGarageTest() {
		GarageDatabase data = new GarageDatabase();
		
		BigDecimal PRICE = new BigDecimal("10");
		Garage garage = new Garage("-1.4758618,-48.457288", PRICE, "garage");
		
		data.enableGarage(garage);
		
		Assertions.assertEquals(1, data.getNumberOfAvailableGarages());
	}
	
	@Test
	void disableGarageTest() {
		GarageDatabase data = new GarageDatabase();
		
		BigDecimal PRICE = new BigDecimal("10");
		Garage garage1 = new Garage("-1.4758618,-48.457288", PRICE, "garage1");
		Garage garage2 = new Garage("-1.4758618,-48.457288", PRICE, "garage2");
		
		data.enableGarage(garage1);
		data.enableGarage(garage2);
		data.disableGarage(garage1);
		
		Assertions.assertEquals(1, data.getNumberOfAvailableGarages());
	}
	
	@Test
	void closestGarageTest() {
		BigDecimal PRICE = new BigDecimal("10");
		Garage garage1 = new Garage("-1.4313795,-48.4625459", PRICE, "UATA?!DUQUE");
		Garage garage2 = new Garage("-1.4454059,-48.4859705", PRICE, "UATA?!UMARIZAL");
		Garage garage3 = new Garage("-1.3566207,-48.4537499", PRICE, "UATA?!AUGUSTOMONTENEGRO");
		
		Driver jhow = new Driver();
		jhow.setLocation("-1.3688387,-48.4719525");
		
		GarageDatabase data = new GarageDatabase();
		data.enableGarage(garage1);
		data.enableGarage(garage2);
		data.enableGarage(garage3);
		
		Garage closestGarage = data.searchTheClosestGarage(jhow);
		
		Assertions.assertEquals(garage3, closestGarage);
	}
}
