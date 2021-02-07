package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sourceCode.GarageSearch;
import sourceCode.*;
class GarageSearchTest {

	@Test
	void getTheClosestGarage() {
		GarageSearch test = new GarageSearch();
		BigDecimal CONSTANT_LENGTH = new BigDecimal("1000");
		Garage home = new Garage("-1.3688387,-48.4719525", "home",CONSTANT_LENGTH, CONSTANT_LENGTH);
		Garage momsHome = new Garage("-1.4110308,-48.4732266", "momshome",CONSTANT_LENGTH, CONSTANT_LENGTH);
		Garage uata = new Garage("-1.4313741,-48.4647346", "uata",CONSTANT_LENGTH, CONSTANT_LENGTH);
		
		List<Garage> garages = new ArrayList<>();
		garages.add(home);
		garages.add(momsHome);
		garages.add(uata);
		
		String casota = "-1.4078921,-48.4658382";
		
		Routes route = new Routes();
		GarageDatabase data = new GarageDatabase(route);
		Car car = new Car("JTDZN3EU0E3298500");
		PaymentDatabase paymentDatabase = new PaymentDatabase();
		Driver driver = new Driver(data, car, paymentDatabase, null, null);

		driver.setLocation(casota);
		
		//Garage closest = test.closestGarage(garages, jhow);
		
		//System.out.println(closest.getName());
	}
	
	@Test
	void showRouteTest() {
		Routes route = new Routes();
		route.calculatingRoute("-1.3688387,-48.4719525", "-1.4313741,-48.4647346");
		GarageSearch test = new GarageSearch();
		test.showRoute(1);
	}
}
