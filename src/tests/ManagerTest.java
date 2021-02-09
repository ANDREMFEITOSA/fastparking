package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;

import sourceCode.*;
import org.junit.jupiter.api.Test;

class ManagerTest {

	@Test
	void removeDriverTest() {
		Database database = new Database();
		Manager manager = new Manager(database);
		
		Driver driver = new Driver(new Car("JTDZN3EU0E3298500"), database, "jhow");
		
		manager.unsubscribeDriver(driver);
		
		driver.subimitComplaint("blabla");
	}
	
	@Test
	void removeHostTest() {
		Database database = new Database();
		Manager manager = new Manager(database);
		
		Garage garage = new Garage("", "", null, null);
		
		Host host = new Host("jordan", "", garage, database);
		
		manager.unsubscribeHost(host);
		
		host.subimitComplaint("blabla");
	}
	
	@Test
	void authorizeRefundTest() throws InterruptedException {
		Database database = new Database();
		
		Manager manager = new Manager(database);
		
		Garage garage_joao = new Garage("-1.4313795,-48.4625459", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		
		garage_joao.setCloseTime(30);
				
		Host host_joao = new Host("João", "", garage_joao, database);
		
		host_joao.enableGarage();
		
		Driver driver_pedro = new Driver(new Car("JTDZN3EU0E3298500"), database, "Pedro");
		
		driver_pedro.setLocation("-1.3688387,-48.4719525");
		
		driver_pedro.reserveGarage(15, "yes");
		
		Thread.sleep(1 * 1000);//need to open the html file
		
		driver_pedro.confirmCheckIn();
		
		host_joao.confirmCheckIn();
		
		int seconds = 5;
		Thread.sleep(seconds * 1000);
		
		host_joao.confirmCheckOut(5);
		
		driver_pedro.ConfirmCheckOut(5);
		
		driver_pedro.pay();
		
		driver_pedro.newRefundSolicitation("Rude host", 0);
		
		manager.authorizeRefund(database.paymentDatabase.getPayment(0));
		
		Assertions.assertEquals(new BigDecimal("25"), driver_pedro.getCredit());
	}

}
