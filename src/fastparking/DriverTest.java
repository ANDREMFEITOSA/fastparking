package fastparking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DriverTest {

	@Test
	void reserveGarage() throws InterruptedException{
		Garage uata = new Garage("-1.4313795,-48.4625459", "UATA?!DUQUE");
		uata.setCloseTime(30);
		Garage momsHome = new Garage("-1.4110308,-48.4732266", "momshome");
		momsHome.setCloseTime(10);
		
		Routes route = new Routes();
		
		GarageDatabase data = new GarageDatabase(route);
		data.enableGarage(uata);
		data.enableGarage(momsHome);
		
		Driver driver = new Driver(data);
		driver.setLocation("-1.3688387,-48.4719525");
		
		driver.reserveGarage();
		
		Thread.sleep(45 * 1000);
	}
	
	@Test
	void cancellingReservation() throws InterruptedException{
		Garage uata = new Garage("-1.4313795,-48.4625459", "UATA?!DUQUE");
		Garage momsHome = new Garage("-1.4110308,-48.4732266", "momshome");
		Routes route = new Routes();
		GarageDatabase data = new GarageDatabase(route);
		data.enableGarage(uata);
		data.enableGarage(momsHome);
		
		Driver driver = new Driver(data);
		driver.setLocation("-1.3688387,-48.4719525");
		
		//driver.reserveGarage();
		
		//Thread.sleep(60 * 1000);
	}
}
