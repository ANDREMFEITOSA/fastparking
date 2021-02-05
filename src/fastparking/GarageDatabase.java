package fastparking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GarageDatabase {
	GarageSearch search;
	private List<Garage> availableGarages;
	private Routes route;
			
	public GarageDatabase(Routes routes) {
		this.search = new GarageSearch();
		this.availableGarages = new ArrayList<>();
		this.route = routes;
	}
	
	public void enableGarage(Garage garage) {
		this.availableGarages.add(garage);
	}
	
	public void disableGarage(Garage garage) {
		this.availableGarages.remove(garage);
	}
	
	public Garage searchTheClosestGarage(Driver driver) {
		if(this.possibleGarages(driver).size() > 0) {
			return search.closestGarage(this.possibleGarages(driver), driver);
		}else {
			return null;
		}		
	}
	
	public int getNumberOfAvailableGarages() {
		return availableGarages.size();
	}
	
	public void showRoute(String origin, String destination) {
		int routeNumber = this.route.getRouteNumber();
		this.route.calculatingRoute(origin, destination);
		this.search.showRoute(routeNumber);
	}
	
	public List<Garage> possibleGarages(Driver driver){
		List<Garage> possibleGarages = new ArrayList<>();
		
		for(int i = 0; i < availableGarages.size(); i++) {
			LocalDateTime driverActualTime = LocalDateTime.now();
			LocalDateTime driverDepartureTime = driverActualTime.plusSeconds
					(driver.getReservationTime());
			
			if(driverDepartureTime.isBefore(availableGarages.get(i).getCloseTime())) {
				possibleGarages.add(availableGarages.get(i));
			}
		}
		
		return possibleGarages;
	}
}
