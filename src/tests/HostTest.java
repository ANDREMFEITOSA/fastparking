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
		
		RouteCalculation route = new RouteCalculation();
		
		GarageDatabase garageDatabase = new GarageDatabase(route);
		
		ComplaintsDatabase complaintDatabase = new ComplaintsDatabase();
		
		Database database = new Database();
		
		Garage garage_joao = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_paulo = new Garage("Boa Ventura", "Vikings", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_andre = new Garage("Oliveira Belo", "El Patron", new BigDecimal("1000"), new BigDecimal("1000"));
		
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "", garage_joao, database);
		Host host_paulo = new Host("Paulo", "222.000.000-02", "yyy", "", garage_paulo, database);
		Host host_andre = new Host("Andre", "333.000.000-03", "zzz", "", garage_paulo, database);
		
		host_joao.enableGarage(garageDatabase);
		host_paulo.enableGarage(garageDatabase);
		host_andre.enableGarage(garageDatabase);
		
		Assertions.assertEquals(3, garageDatabase.getNumberOfAvailableGarages());
	}
	
	@Test
	void disableGarageTest() {
		RouteCalculation route = new RouteCalculation();
		
		GarageDatabase garageDatabase = new GarageDatabase(route);
		
		ComplaintsDatabase complaintDatabase = new ComplaintsDatabase();
		
		Database database = new Database();
		
		
		Garage garage_joao = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_paulo = new Garage("Boa Ventura", "Vikings", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_andre = new Garage("Oliveira Belo", "El Patron", new BigDecimal("1000"), new BigDecimal("1000"));
		
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "", garage_joao, database);
		Host host_paulo = new Host("Paulo", "222.000.000-02", "yyy","", garage_paulo, database);
		Host host_andre = new Host("Andre", "333.000.000-03", "zzz", "", garage_paulo, database);
		
		host_joao.enableGarage(garageDatabase);
		host_paulo.enableGarage(garageDatabase);
		host_andre.enableGarage(garageDatabase);
		
		host_joao.disableGarage(garageDatabase);
		
		Assertions.assertEquals(2, garageDatabase.getNumberOfAvailableGarages());
	}
	
	@Test
	void confirmCheckInAndChekOutTest() throws InterruptedException {
		
		RouteCalculation route = new RouteCalculation();
		
		GarageDatabase garageDatabase = new GarageDatabase(route);
		
		Database database = new Database();
		
		Garage garage_joao = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_paulo = new Garage("Boa Ventura", "Vikings", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_andre = new Garage("Oliveira Belo", "El Patron", new BigDecimal("1000"), new BigDecimal("1000"));
		
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "", garage_joao, database);
		Host host_paulo = new Host("Paulo", "222.000.000-02", "yyy", "", garage_paulo, database);
		Host host_andre = new Host("Andre", "333.000.000-03", "zzz", "", garage_paulo, database);
		
		host_joao.enableGarage(garageDatabase);
		host_paulo.enableGarage(garageDatabase);
		host_andre.enableGarage(garageDatabase);
		
		host_joao.confirmCheckIn(garageDatabase);
		host_paulo.confirmCheckIn(garageDatabase);
		host_andre.confirmCheckIn(garageDatabase);
		
		Driver driver_pedro = new Driver(new Car("JTDZN3EU0E3298500"), null, null);
		Driver driver_tiago = new Driver(new Car("JTDZN3EU0E3298500"), null, null);
		Driver driver_jose = new Driver(new Car("JTDZN3EU0E3298500"), null, null);
		
		driver_pedro.confirmCheckIn();
		driver_tiago.confirmCheckIn();
		driver_jose.confirmCheckIn();
		
		int seconds = 2;
		Thread.sleep(seconds * 1000);
		
		host_joao.confirmCheckOut();
		host_paulo.confirmCheckOut();
		host_andre.confirmCheckOut();

		driver_pedro.ConfirmCheckOut();
		driver_tiago.ConfirmCheckOut();
		driver_jose.ConfirmCheckOut();
		
		garage_joao.getDuration();
		garage_paulo.getDuration();
		garage_andre.getDuration();
		
		Assertions.assertEquals(3, garageDatabase.getNumberOfAvailableGarages());
		
		Assertions.assertEquals("2", garage_joao.getDuration().toPlainString());
		Assertions.assertEquals("2", garage_paulo.getDuration().toPlainString());
		Assertions.assertEquals("2", garage_andre.getDuration().toPlainString());
	}
}
