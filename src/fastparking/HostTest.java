package fastparking;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HostTest {

	@Test
	void enableGarageTest() {
		
		Routes route = new Routes();
		
		GarageDatabase garageDatabase = new GarageDatabase(route);
		
		Garage garage_joao = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_paulo = new Garage("Boa Ventura", "Vikings", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_andre = new Garage("Oliveira Belo", "El Patron", new BigDecimal("1000"), new BigDecimal("1000"));
		
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "000000", garage_joao, 10);
		Host host_paulo = new Host("Paulo", "222.000.000-02", "yyy", "000000", garage_paulo, 10);
		Host host_andre = new Host("Andre", "333.000.000-03", "zzz", "000000", garage_paulo, 10);
		
		host_joao.enableGarage(garageDatabase);
		host_paulo.enableGarage(garageDatabase);
		host_andre.enableGarage(garageDatabase);
		
		Assertions.assertEquals(3, garageDatabase.getNumberOfAvailableGarages());
	}
	
	@Test
	void disableGarageTest() {
		Routes route = new Routes();
		
		GarageDatabase garageDatabase = new GarageDatabase(route);
		
		Garage garage_joao = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_paulo = new Garage("Boa Ventura", "Vikings", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_andre = new Garage("Oliveira Belo", "El Patron", new BigDecimal("1000"), new BigDecimal("1000"));
		
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "000000", garage_joao, 10);
		Host host_paulo = new Host("Paulo", "222.000.000-02", "yyy", "000000", garage_paulo, 10);
		Host host_andre = new Host("Andre", "333.000.000-03", "zzz", "000000", garage_paulo, 10);
		
		host_joao.enableGarage(garageDatabase);
		host_paulo.enableGarage(garageDatabase);
		host_andre.enableGarage(garageDatabase);
		
		host_joao.disableGarage(garageDatabase);
		
		Assertions.assertEquals(2, garageDatabase.getNumberOfAvailableGarages());
	}
	
	@Test
	void confirmCheckInTest() {
		Routes route = new Routes();
		
		GarageDatabase garageDatabase = new GarageDatabase(route);
		
		Garage garage_joao = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_paulo = new Garage("Boa Ventura", "Vikings", new BigDecimal("1000"), new BigDecimal("1000"));
		Garage garage_andre = new Garage("Oliveira Belo", "El Patron", new BigDecimal("1000"), new BigDecimal("1000"));
		
		Host host_joao = new Host("João", "111.000.000-01", "xxx", "000000", garage_joao, 10);
		Host host_paulo = new Host("Paulo", "222.000.000-02", "yyy", "000000", garage_paulo, 10);
		Host host_andre = new Host("Andre", "333.000.000-03", "zzz", "000000", garage_paulo, 10);
		
		host_joao.enableGarage(garageDatabase);
		host_paulo.enableGarage(garageDatabase);
		host_andre.enableGarage(garageDatabase);
		
		PaymentDatabase paymentDatabase = new PaymentDatabase();
		Driver driver_pedro = new Driver(garageDatabase, new Car("JTDZN3EU0E3298500"), paymentDatabase);
		host_joao.getGarage().setTimeCheckIn(driver_pedro);
		
		Driver driver_tiago = new Driver(garageDatabase, new Car("JTDZN3EU0E3298500"), paymentDatabase);
		host_paulo.getGarage().setTimeCheckIn(driver_tiago);
		
		host_joao.confirmCheckIn(garageDatabase);
		host_paulo.confirmCheckIn(garageDatabase);
		
		LocalDateTime joao_timeCheckIn = host_joao.getGarage().getTimeCheckIn();
		LocalDateTime paulo_timeCheckIn = host_paulo.getGarage().getTimeCheckIn();
		Duration duration = Duration.between(paulo_timeCheckIn, joao_timeCheckIn);
		
		BigDecimal durationTest = BigDecimal.valueOf(duration.toMinutes());
		
		Assertions.assertEquals(1, garageDatabase.getNumberOfAvailableGarages());
		
		Assertions.assertEquals("0", durationTest.toPlainString());
	}
}
