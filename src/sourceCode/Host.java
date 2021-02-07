package sourceCode;

import java.time.LocalDateTime;

public class Host {
	
	private String name;
	private String cpf;
	private String proofOfAddress;
	private String account;
	private Garage garage;
	private int score;
	private ComplaintDatabase complaintDatabase;
	
	public Host(String name, String cpf, String proofOfAddress, String account,
			Garage garage, ComplaintDatabase complaintDatabase) {
		this.name = name;
		this.cpf = cpf;
		this.proofOfAddress = proofOfAddress;
		this.account = account;
		this.garage = garage;
		this.score = score;
		this.complaintDatabase = complaintDatabase;
		
		this.garage.setHost(this);
	}

	public void enableGarage(GarageDatabase garageDatabase) {
		
		garageDatabase.enableGarage(this.garage, this);
		
	}
	
	public void disableGarage(GarageDatabase garageDatabase) {
		
		garageDatabase.disableGarage(this.garage, this);
		
	}
	
	public void confirmCheckIn(GarageDatabase garageDatabase) {
		this.garage.setTimeCheckIn(this);
		this.disableGarage(garageDatabase);
	}
	
	public void confirmCheckOut() {
		this.garage.setTimeCheckOut(this);
	}
	
	public Garage getGarage() {
		return this.garage;
	}
	
	public void subimitComplaint(String content) {
		this.complaintDatabase.add(new Complaint(this, content));
	}
	
	public void evaluateDriver(GarageDatabase garageDatabase, Driver driver) {
		
	}
	
	public String getBankAccount() {
		return this.account;
	}
}
