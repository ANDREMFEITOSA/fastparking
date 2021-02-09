package tests;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sourceCode.*;
class PaymentTest {
	
	@Test
	void paymentAmountWithCheckInTest() throws InterruptedException {

		Database database = new Database();
		
		Garage garage_joao = new Garage("-1.4313795,-48.4625459", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		
		garage_joao.setCloseTime(30);
				
		Host host_joao = new Host("João", "", garage_joao, database);
		
		database.hostsDatabase.add(host_joao);
		
		host_joao.enableGarage();
		
		Driver driver_pedro = new Driver(new Car("JTDZN3EU0E3298500"), database, "Pedro");
		
		driver_pedro.setLocation("-1.3688387,-48.4719525");
		
		driver_pedro.reserveGarage(10, "yes");
		
		driver_pedro.confirmCheckIn();
		
		host_joao.confirmCheckIn();
		
		int seconds = 10;
		Thread.sleep(seconds * 1000);
		
		host_joao.confirmCheckOut(5);
		
		driver_pedro.ConfirmCheckOut(5);
		
		driver_pedro.pay();
		
		BigDecimal driverValue = database.paymentDatabase.getPayment(0).getValueDriver();
		BigDecimal hostValue = database.paymentDatabase.getPayment(0).getValueHost();
		
		Assertions.assertEquals(new BigDecimal("50"), driverValue);
		Assertions.assertEquals(new BigDecimal("42.50"), hostValue);
	}

	@Test
	void paymentAmountWithoutCheckInTest() throws InterruptedException {

		Database database = new Database();
		
		Garage garage_joao = new Garage("-1.4313795,-48.4625459", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		
		garage_joao.setCloseTime(30);
				
		Host host_joao = new Host("João", "", garage_joao, database);
		
		database.hostsDatabase.add(host_joao);
		
		host_joao.enableGarage();
		
		Driver driver_pedro = new Driver(new Car("JTDZN3EU0E3298500"), database, "Pedro");
		
		driver_pedro.setLocation("-1.3688387,-48.4719525");
		
		driver_pedro.reserveGarage(15, "yes");
		
		Thread.sleep(16 * 1000);
		
		BigDecimal driverValue = database.paymentDatabase.getPayment(0).getValueDriver();
		BigDecimal hostValue = database.paymentDatabase.getPayment(0).getValueHost();
		
		Assertions.assertEquals(new BigDecimal("2.5"), driverValue);
		Assertions.assertEquals(new BigDecimal("2.125"), hostValue);
	}
}
