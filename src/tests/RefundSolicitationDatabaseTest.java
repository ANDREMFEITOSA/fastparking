package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import sourceCode.*;

class RefundSolicitationDatabaseTest {

	@Test
	void newRefundSolicitationtTest() throws InterruptedException {
		Database database = new Database();
		
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
		
		driver_pedro.newRefundSolicitation("Garage was too dirty", 0);
					
		database.refundDatabase.getNext().showReason();		
	}

}
