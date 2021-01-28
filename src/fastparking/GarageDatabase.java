package fastparking;

import java.util.ArrayList;
import java.util.List;

public class GarageDatabase {
	HTTPRequest search;
	private List<Garage> availableGarages;
			
	public GarageDatabase() {
		this.availableGarages = new ArrayList<>();
		this.search = new HTTPRequest();
	}
	
	public void enableGarage(Garage garage) {
		this.availableGarages.add(garage);
	}
	
	public void disableGarage(Garage garage) {
		this.availableGarages.remove(garage);
	}
	
	public Garage searchTheClosestGarage(Driver driver) {
		return search.closestGarage(availableGarages, driver);
	}
	
}
