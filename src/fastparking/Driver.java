package fastparking;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {	
	private String name;
	private String cpf;
	private String carDocument;
	private CreditCard card;
	private float score;
	private int numberOfEvaluations;
	private Garage garage;
	private Manager manager;
	private String location;
	private GarageDatabase garageDatabase;
	private Routes route;
	
	Driver(GarageDatabase garageDatabase){
		this.garageDatabase = garageDatabase;
	}
	
	public void reserveGarage() {
		this.garage = garageDatabase.searchTheClosestGarage(this);
		garageDatabase.disableGarage(garage);	
		garageDatabase.showRoute(this.location, this.garage.getLocation());
		
		Scanner in = new Scanner(System.in); 
		 
		System.out.println("Do you wanna reserv this garage? yes or no");
        String answer = in.nextLine(); 
        
        if(answer.equals("yes")) {
        	
        }else {
        	garageDatabase.enableGarage(garage);
        }
	}

	public void pay() {
		
	}
	
	public void confirmCheckIn() {
		this.garage.setTimeCheckIn(this);
	}
	
	public void ConfirmCheckOut() {
		this.garage.setTimeCheckOut(this);
	}
	
	public void askForRefund(String description) {
		this.manager.refundSolicitation(description);
	}
	
	public void subimitComplaint(String complaint) {
		this.manager.newComplaint(complaint);
	}
	
	public void evaluation(int evaluation) {
		numberOfEvaluations++;
		score = (score + evaluation)/numberOfEvaluations;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}
