package fastparking;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GarageSearchTest {

	@Test
	void requestTest() {
		GarageSearch test = new GarageSearch();
		String house = "-1.3688387,-48.4719525|-1.4110308,-48.4732266";
		String uata = "-1.4313741,-48.4647346";
		
		//test.request(uata, house);
	}
	
	@Test
	void getTheClosestGarage() {
		GarageSearch test = new GarageSearch();
				
		Garage home = new Garage("-1.3688387,-48.4719525", "home");
		Garage momsHome = new Garage("-1.4110308,-48.4732266", "momshome");
		Garage uata = new Garage("-1.4313741,-48.4647346", "uata");
		
		List<Garage> garages = new ArrayList<>();
		garages.add(home);
		garages.add(momsHome);
		garages.add(uata);
		
		String casota = "-1.4078921,-48.4658382";
		
		Routes route = new Routes();
		GarageDatabase data = new GarageDatabase(route);
		Driver jhow = new Driver(data);

		jhow.setLocation(casota);
		
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
