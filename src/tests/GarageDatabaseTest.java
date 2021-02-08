package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sourceCode.GarageDatabase;
import sourceCode.RouteCalculation;
import sourceCode.*;

class GarageDatabaseTest {

	@Test
	void enableGarageTest() {
		RouteCalculation routes = new RouteCalculation();
		GarageDatabase data = new GarageDatabase(routes);
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage garage = new Garage("-1.4758618,-48.457288", "garage", CONSTANT_LENGTH, CONSTANT_LENGTH);
		
		data.enableGarage(garage, data);
		
		Assertions.assertEquals(1, data.getNumberOfAvailableGarages());
	}
	
	@Test
	void disableGarageTest() {
		RouteCalculation routes = new RouteCalculation();
		GarageDatabase data = new GarageDatabase(routes);
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage garage1 = new Garage("-1.4758618,-48.457288", "garage1",CONSTANT_LENGTH, CONSTANT_LENGTH);
		Garage garage2 = new Garage("-1.4758618,-48.457288", "garage2", CONSTANT_LENGTH, CONSTANT_LENGTH);
		
		data.enableGarage(garage1, data);
		data.enableGarage(garage2, data);
		data.disableGarage(garage1, data);
		
		Assertions.assertEquals(1, data.getNumberOfAvailableGarages());
	}
	
	@Test
	void closestGarageTest() {
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage garage1 = new Garage("-1.4313795,-48.4625459", "UATA?!DUQUE",CONSTANT_LENGTH, CONSTANT_LENGTH);
		Garage garage2 = new Garage("-1.4454059,-48.4859705", "UATA?!UMARIZAL",CONSTANT_LENGTH, CONSTANT_LENGTH);
		Garage garage3 = new Garage("-1.3566207,-48.4537499", "UATA?!AUGUSTOMONTENEGRO",CONSTANT_LENGTH, CONSTANT_LENGTH);
				
		RouteCalculation routes = new RouteCalculation();
		GarageDatabase data = new GarageDatabase(routes);
		data.enableGarage(garage1, data);
		data.enableGarage(garage2, data);
		data.enableGarage(garage3, data);
		
		Car car = new Car("JTDZN3EU0E3298500");
		
		Driver driver = new Driver(car, null);
		driver.setLocation("-1.3688387,-48.4719525");
		
		//Garage closestGarage = data.searchTheClosestGarage(jhow);
		
		//System.out.println(closestGarage.getName());
		
		//Assertions.assertEquals(garage3, closestGarage);
	}
	
	@Test
	void showRouteTest() {
		RouteCalculation routes = new RouteCalculation();
		GarageDatabase data = new GarageDatabase(routes);
		data.showRoute("-1.3688387,-48.4719525", "-1.4313795,-48.4625459");
	}
}
