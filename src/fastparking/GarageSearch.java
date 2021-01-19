package fastparking;

import java.lang.Math;

import java.util.List;

public class GarageSearch {
	
	private List<Garage> availableGarages;
	private List<Garage> nextAvailableGarages;
	float radius;
	
	public GarageSearch(float radius) {
		this.radius = radius;
	}
	
	public void addAvailableGarages(Garage garage) {
		this.availableGarages.add(garage);
	}
	
	public void removeAvailableGarages(Garage garage) {
		this.availableGarages.remove(garage);
	}
	
	public List<Garage> searchAvailableGarages(User user){
		
		final float posGarageX;
		final float posGarageY;
		final float posUserX;
		final float posUserY;
		
		for(int i=0; i< this.availableGarages.size(); i++) {
			posGarageX = this.availableGarages.get(i).getLocationX();
			posGarageY = this.availableGarages.get(i).getLocationY();
			posUserX = user.getLocationX();
			posUserY = user.getLocationY();
			if (this.radius >= Math.sqrt(Math.pow(posGarageX - posUserX, 2) + Math.pow(posGarageY - posUserY, 2)))
				
				nextAvailableGarages.add(availableGarages.get(i)); 
		}
		
		return this.nextAvailableGarages;
	}
	

}
