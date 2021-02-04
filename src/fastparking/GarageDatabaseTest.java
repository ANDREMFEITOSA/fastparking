package fastparking;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GarageDatabaseTest {

	@Test
	void enableGarageTest() {
		Routes routes = new Routes();
		GarageDatabase data = new GarageDatabase(routes);
		
		Garage garage = new Garage("-1.4758618,-48.457288", "garage");
		
		data.enableGarage(garage);
		
		Assertions.assertEquals(1, data.getNumberOfAvailableGarages());
	}
	
	@Test
	void disableGarageTest() {
		Routes routes = new Routes();
		GarageDatabase data = new GarageDatabase(routes);
		
		Garage garage1 = new Garage("-1.4758618,-48.457288", "garage1");
		Garage garage2 = new Garage("-1.4758618,-48.457288", "garage2");
		
		data.enableGarage(garage1);
		data.enableGarage(garage2);
		data.disableGarage(garage1);
		
		Assertions.assertEquals(1, data.getNumberOfAvailableGarages());
	}
	
	@Test
	void closestGarageTest() {
		Garage garage1 = new Garage("-1.4313795,-48.4625459", "UATA?!DUQUE");
		Garage garage2 = new Garage("-1.4454059,-48.4859705", "UATA?!UMARIZAL");
		Garage garage3 = new Garage("-1.3566207,-48.4537499", "UATA?!AUGUSTOMONTENEGRO");
		
		Driver jhow = new Driver();
		jhow.setLocation("-1.3688387,-48.4719525");
		
		Routes routes = new Routes();
		GarageDatabase data = new GarageDatabase(routes);
		data.enableGarage(garage1);
		data.enableGarage(garage2);
		data.enableGarage(garage3);
		
		//Garage closestGarage = data.searchTheClosestGarage(jhow);
		
		//System.out.println(closestGarage.getName());
		
		//Assertions.assertEquals(garage3, closestGarage);
	}
	
	@Test
	void closestGaragesTest() {
		Garage garage1 = new Garage("-1.4313795,-48.4625459", "UATA?!DUQUE");
		Garage garage2 = new Garage("-1.4454059,-48.4859705", "UATA?!UMARIZAL");
		Garage garage3 = new Garage("-1.3566207,-48.4537499", "UATA?!AUGUSTOMONTENEGRO");
		
		Driver jhow = new Driver();
		jhow.setLocation("-1.3688387,-48.4719525");
		
		Routes routes = new Routes();
		GarageDatabase data = new GarageDatabase(routes);
		data.enableGarage(garage1);
		data.enableGarage(garage2);
		data.enableGarage(garage3);
		data.setPerimeter(11000);
		
		/*List<Garage> closestGarages = data.searchTheClosestGarages(jhow);
		
		List<Garage> closestGaragesExpected = new ArrayList<>();
		closestGaragesExpected.add(garage1);
		closestGaragesExpected.add(garage3);
		
		for(int i = 0; i < closestGarages.size(); i++) {
			System.out.println(closestGarages.get(i).getName());
		}		
		
		Assertions.assertEquals(closestGaragesExpected, closestGarages);*/
	}
	
	@Test
	void showRouteTest() {
		Routes routes = new Routes();
		GarageDatabase data = new GarageDatabase(routes);
		data.showRoute("-1.3688387,-48.4719525", "-1.4313795,-48.4625459");
	}
}
