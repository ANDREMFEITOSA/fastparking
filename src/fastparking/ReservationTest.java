package fastparking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReservationTest {

	@Test
	void driverIsOffTheGarageReservationTest() throws InterruptedException {
		Garage garage = new Garage("location","name");
		Routes routes = new Routes();
		GarageDatabase garagaDatabase = new GarageDatabase(routes);
		new Reservation(1, garage, garagaDatabase);
		int seconds = 2;
		Thread.sleep(seconds * 1000); 	
		Assertions.assertEquals(1, garagaDatabase.getNumberOfAvailableGarages());
	}
	
	@Test
	void cancelReservation() throws InterruptedException {
		Garage garage = new Garage("location","name");
		Routes routes = new Routes();
		GarageDatabase garagaDatabase = new GarageDatabase(routes);
		Reservation reservation = new Reservation(3, garage, garagaDatabase);
		reservation.cancelReservation();
		int seconds = 5;
		Thread.sleep(seconds * 1000); 	
		Assertions.assertEquals(1, garagaDatabase.getNumberOfAvailableGarages());
	}
}