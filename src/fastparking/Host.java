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
		super();
		this.name = name;
		this.cpf = cpf;
		this.proofOfAddress = proofOfAddress;
		this.account = account;
		this.garage = garage;
		this.score = score;
	}

	public void enableGarage(GarageSearch garageSearc) {
		
		this.garage.enable();
		garageSearc.addAvailableGarages(this.garage);
		
	}
	
	public void disableGarage() {
		
		this.garage.disable();
		
	}
	
	public void confirmCheckIn() {
		this.garage.setTimeCheckIn(LocalDateTime.now());
		this.garage.disable();
	}
	
	public void confirmCheckOut() {
		this.garage.setTimeCheckOut(LocalDateTime.now());
	}
	
	public void submitComplaint() {
		
	}
	
	public void evaluateUser() {
		
	}

}
