package sourceCode;

import java.time.LocalDateTime;

public class Host {
	
	private String name;
	private String cpf;
	private String proofOfAddress;
	private String account;
	private Garage garage;
	private int score;
	private ComplaintsDatabase complaintDatabase;
	private Database database;
	
	public Host(String name, String cpf, String proofOfAddress, String account,
			Garage garage, Database database) {
		this.name = name;
		this.cpf = cpf;
		this.proofOfAddress = proofOfAddress;
		this.account = account;
		this.garage = garage;
		this.complaintDatabase = complaintDatabase;
		this.database = database;
		this.score = 0;
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
		try {
			this.isSubscribed();
			this.database.complaintsDatabase.add(new Complaint(this, content));
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void evaluateDriver(GarageDatabase garageDatabase, Driver driver) {
		
	}
	
	public String getBankAccount() {
		return this.account;
	}
	
	public void isSubscribed () throws SubscriptionNotFoundException{
		if(!this.database.hostsDatabase.isSubscribed(this)) {
			throw new SubscriptionNotFoundException(this.name + 
					" You're not subscribed in our platform.");
		}
	}
}
