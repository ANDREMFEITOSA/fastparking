package fastparking;

import java.time.LocalDateTime;

public class Host {
	
	private String name;
	private String cpf;
	private String proofOfAddress;
	private String account;
	private Garage garage;
	private int score;
	
	public Host(String name, String cpf, String proofOfAddress, String account,
			Garage garage, int score) {
		this.name = name;
		this.cpf = cpf;
		this.proofOfAddress = proofOfAddress;
		this.account = account;
		this.garage = garage;
		this.score = score;
	}

	public void enableGarage(GarageSearch garageSearch) {
		
		garageSearch.addAvailableGarages(this.garage);
		
	}
	
	public void disableGarage(GarageSearch garageSearch) {
		
		garageSearch.removeAvailableGarages(this.garage);
		
	}
	
	public void confirmCheckIn(GarageSearch garageSearch) {
		this.garage.setTimeCheckIn(LocalDateTime.now());
		this.disableGarage(garageSearch);
	}
	
	public void confirmCheckOut() {
		this.garage.setTimeCheckOut(LocalDateTime.now());
	}
	
	public Garage getGarage() {
		return this.garage;
	}
	
	public void submitComplaint() {
		
	}
	
	public void evaluateUser() {
		
	}

}
