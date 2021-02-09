package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sourceCode.*;

class DriverTest {

	@Test
	void reserveGarage() throws InterruptedException{
		Database database = new Database();
		
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage uata = new Garage("-1.4313795,-48.4625459", "UATA?!DUQUE", CONSTANT_LENGTH, CONSTANT_LENGTH);
		uata.setCloseTime(60);
		
		BigDecimal length = new BigDecimal("4.5");
		BigDecimal width = new BigDecimal("3");
		Garage momsHome = new Garage("-1.4110308,-48.4732266", "momshome", length, width);
		momsHome.setCloseTime(60);
				
		database.garageDatabase.enableGarage(uata, this);
		database.garageDatabase.enableGarage(momsHome, this);
		
		Car car = new Car("JTDZN3EU0E3298500");
		
		Driver driver = new Driver(car, database, "jhow");
						
		driver.setLocation("-1.3688387,-48.4719525");
				
		Driver driver2 = new Driver(car, database, "jordan");
		
		driver.reserveGarage(15, "yes");
		
		Thread.sleep(13 * 1000);
	}
	
	@Test
	void cancellingReservation() throws InterruptedException{
		Database database = new Database();
		
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage uata = new Garage("-1.4313795,-48.4625459", "UATA?!DUQUE", CONSTANT_LENGTH, CONSTANT_LENGTH);
		uata.setCloseTime(60);
		
		BigDecimal length = new BigDecimal("4.5");
		BigDecimal width = new BigDecimal("3");
		Garage momsHome = new Garage("-1.4110308,-48.4732266", "momshome", length, width);
		momsHome.setCloseTime(60);
				
		database.garageDatabase.enableGarage(uata, this);
		database.garageDatabase.enableGarage(momsHome, this);
		
		Car car = new Car("JTDZN3EU0E3298500");
		
		Driver driver = new Driver(car, database, "jhow");
						
		driver.setLocation("-1.3688387,-48.4719525");
				
		driver.reserveGarage(15, "yes");
		
		int cacelationTime = 5;
		Thread.sleep(cacelationTime * 1000);
		
		driver.cancelReservation();
		
		Thread.sleep(10 * 1000);
	}
		
}
