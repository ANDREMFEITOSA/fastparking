package tests;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sourceCode.Car;
import sourceCode.ComplaintsDatabase;
import sourceCode.Database;
import sourceCode.Driver;
import sourceCode.Garage;
import sourceCode.GarageDatabase;
import sourceCode.Host;
import sourceCode.PaymentDatabase;
import sourceCode.RouteCalculation;
class HostTest {

	@Test
	void enableGarageTest() {
		
		Database database = new Database();
		
		Garage garage_joao = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_paulo = new Garage("Boa Ventura", "Vikings", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_andre = new Garage("Oliveira Belo", "El Patron", new BigDecimal("1000"), new BigDecimal("1000"));
		
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "", garage_joao, database);
		Host host_paulo = new Host("Paulo", "222.000.000-02", "yyy", "", garage_paulo, database);
		Host host_andre = new Host("Andre", "333.000.000-03", "zzz", "", garage_paulo, database);
		
		database.hostsDatabase.add(host_joao);
		database.hostsDatabase.add(host_paulo);
		database.hostsDatabase.add(host_andre);
		
		host_joao.enableGarage();
		host_paulo.enableGarage();
		host_andre.enableGarage();
		
		Assertions.assertEquals(3, database.garageDatabase.getNumberOfAvailableGarages());
	}
	
	@Test
	void disableGarageTest() {
		
		RouteCalculation route = new RouteCalculation();
		
		GarageDatabase garageDatabase = new GarageDatabase(route);

		Database database = new Database();
	
		Garage garage_joao = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_paulo = new Garage("Boa Ventura", "Vikings", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_andre = new Garage("Oliveira Belo", "El Patron", new BigDecimal("1000"), new BigDecimal("1000"));
		
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "", garage_joao, database);
		Host host_paulo = new Host("Paulo", "222.000.000-02", "yyy","", garage_paulo, database);
		Host host_andre = new Host("Andre", "333.000.000-03", "zzz", "", garage_paulo, database);
		
		database.hostsDatabase.add(host_joao);
		database.hostsDatabase.add(host_paulo);
		database.hostsDatabase.add(host_andre);
		
		host_joao.enableGarage();
		host_paulo.enableGarage();
		host_andre.enableGarage();
		
		host_joao.disableGarage();
		
		Assertions.assertEquals(2, database.garageDatabase.getNumberOfAvailableGarages());
	}
	
	@Test
	void confirmCheckInAndChekOutTest() throws InterruptedException {
		
		Database database = new Database();
		
		Garage garage_joao = new Garage("-1.4313795,-48.4625459", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		
		garage_joao.setCloseTime(30);
				
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "", garage_joao, database);
		
		database.hostsDatabase.add(host_joao);
		
		host_joao.enableGarage();
		
		Driver driver_pedro = new Driver(new Car("JTDZN3EU0E3298500"), database, "Pedro");
		
		driver_pedro.setLocation("-1.3688387,-48.4719525");
		
		driver_pedro.reserveGarage();
		
		driver_pedro.confirmCheckIn();
		
		host_joao.confirmCheckIn();
		
		int seconds = 35;
		Thread.sleep(seconds * 1000);
		
		host_joao.confirmCheckOut(5);
		
		driver_pedro.ConfirmCheckOut(5);
		
		Assertions.assertEquals("35", garage_joao.getDuration().toPlainString());
		
		System.out.println("Duracao da reserva:" + garage_joao.getDuration().toPlainString());
		
		Thread.sleep(10 * 1000);
	}
}
