package fastparking;

import java.util.ArrayList;
import java.util.List;

public class GarageDatabase {
	GarageSearch search;
	private List<Garage> availableGarages;
	private float perimeter;
			
	public GarageDatabase() {
		this.availableGarages = new ArrayList<>();
		this.search = new GarageSearch();
		perimeter = 1000;
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
	
	public List<Garage> searchTheClosestGarages(Driver driver) {
		return search.closestGarages(availableGarages, driver, perimeter);
	}
	
	public int getNumberOfAvailableGarages() {
		return availableGarages.size();
	}
	
	public void setPerimeter(float perimeter){
		this.perimeter = perimeter;
	}
}
