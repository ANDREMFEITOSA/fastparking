package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sourceCode.*;
class ReservationTest {

	@Test
	void driverIsOffTheGarageReservationTest() throws InterruptedException {
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage garage = new Garage("location","name", CONSTANT_LENGTH, CONSTANT_LENGTH);
		Routes routes = new Routes();
		GarageDatabase garagaDatabase = new GarageDatabase(routes);
		Reservation reservation = new Reservation(1, garage, garagaDatabase, 
				new Driver(garagaDatabase, new Car("JTDZN3EU0E3298500"), new PaymentDatabase(), null), 
					new PaymentDatabase());
		int seconds = 2;
		Thread.sleep(seconds * 1000); 	
		Assertions.assertEquals(1, garagaDatabase.getNumberOfAvailableGarages());
	}
	
	@Test
	void cancelReservation() throws InterruptedException {
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage garage = new Garage("location","name", CONSTANT_LENGTH, CONSTANT_LENGTH);
		Routes routes = new Routes();
		GarageDatabase garagaDatabase = new GarageDatabase(routes);
		Reservation reservation = new Reservation(3, garage, garagaDatabase, 
				new Driver(garagaDatabase, new Car("JTDZN3EU0E3298500"), new PaymentDatabase(), null), 
					new PaymentDatabase());
		reservation.cancelReservation();
		int seconds = 5;
		Thread.sleep(seconds * 1000); 	
		Assertions.assertEquals(1, garagaDatabase.getNumberOfAvailableGarages());
	}
}
