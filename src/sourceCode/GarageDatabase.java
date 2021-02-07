package sourceCode;

import java.math.BigDecimal;
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

	public void enableGarage(Garage garage, Object obj) {
		this.availableGarages.add(garage);
		
		if(obj instanceof Host) {
			garage.open();
		}
	}

	public void disableGarage(Garage garage, Object obj) {
		this.availableGarages.remove(garage);
		
		if(obj instanceof Host) {
			garage.close();
		}
	}

	public Garage searchTheClosestGarage(Driver driver) {
		if (this.possibleGarages(driver).size() > 0) {
			return search.closestGarage(this.possibleGarages(driver), driver);
		} else {
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

	public List<Garage> possibleGarages(Driver driver) {
		List<Garage> possibleGarages = new ArrayList<>();
		BigDecimal widthSpace = new BigDecimal("1.5");
		BigDecimal lengthSpace = new BigDecimal("0.5");
		
		LocalDateTime driverActualTime = LocalDateTime.now();
		LocalDateTime driverDepartureTime = driverActualTime
				.plusSeconds(driver.getReservationTime());
		
		for(int i = 0; i < availableGarages.size(); i++) {
			if (driverDepartureTime.isBefore(availableGarages.get(i).getCloseTime()) 
					&& availableGarages.get(i).getLength().
						compareTo(driver.getCar().getLength().add(lengthSpace)) > -1
							&& availableGarages.get(i).getWidth().
								compareTo(driver.getCar().getWidth().add(widthSpace)) > -1) {
				possibleGarages.add(availableGarages.get(i));
			}
		}		
		
		return possibleGarages;
	}
}
