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
		uata.setCloseTime(30);
		
		BigDecimal length = new BigDecimal("4.5");
		BigDecimal width = new BigDecimal("3");
		Garage momsHome = new Garage("-1.4110308,-48.4732266", "momshome", length, width);
		momsHome.setCloseTime(30);
				
		database.garageDatabase.enableGarage(uata, this);
		database.garageDatabase.enableGarage(momsHome, this);
		
		Car car = new Car("JTDZN3EU0E3298500");
		
		Driver driver = new Driver(car, database, "jhow");
				
		driver.setLocation("-1.3688387,-48.4719525");
		
		driver.reserveGarage();
				
		Thread.sleep(31 * 1000);
	}
	
	@Test
	void cancellingReservation() throws InterruptedException{
		/*BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage uata = new Garage("-1.4313795,-48.4625459", "UATA?!DUQUE", CONSTANT_LENGTH, CONSTANT_LENGTH);
		uata.setCloseTime(30);
		Garage momsHome = new Garage("-1.4110308,-48.4732266", "momshome", CONSTANT_LENGTH, CONSTANT_LENGTH);
		momsHome.setCloseTime(30);
		Routes route = new Routes();
		GarageDatabase data = new GarageDatabase(route);
		data.enableGarage(uata);
		data.enableGarage(momsHome);
		
		Car car = new Car("JTDZN3EU0E3298500");
		Driver driver = new Driver(data, car);
		driver.setLocation("-1.3688387,-48.4719525");
		
		//driver.reserveGarage();
		
		//driver.cancelReservation();
		
		//Thread.sleep(40 * 1000);*/
	}
		
}
