package fastparking;

import java.util.List;

public class GarageSearch {
	
	private List<Garage> availableGarages;
	private List<Garage> nextAvailableGarages;
	
	public GarageSearch() {
		
	}
	
	public void addAvailableGarages(Garage garage) {
		this.availableGarages.add(garage);
	}
	
	public List<Garage> searchAvailableGarages(User user){
		
		for(int i=0; i< this.availableGarages.size(); i++) {
			if (this.availableGarages.get(i).getLocation() == user.getLocation()) nextAvailableGarages.add(availableGarages.get(i)); 
		}
		
		return this.nextAvailableGarages;
	}
	

}
