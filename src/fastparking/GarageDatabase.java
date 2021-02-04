package fastparking;

import java.util.ArrayList;
import java.util.List;

public class GarageDatabase {
	GarageSearch search;
	private List<Garage> availableGarages;
	private float perimeter;
	private Routes route;
			
	public GarageDatabase(Routes routes) {
		this.search = new GarageSearch();
		this.availableGarages = new ArrayList<>();
		this.route = routes;
		this.perimeter = 1000;
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
	
	public void showRoute(String origin, String destination) {
		int routeNumber = this.route.getRouteNumber();
		this.route.calculatingRoute(origin, destination);
		this.search.showRoute(routeNumber);
	}
}
