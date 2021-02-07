package fastparking;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {	
	private String name;
	private String cpf;
	private String carDocument;
	private String location;
	private CreditCard card;
	private float score;
	private int numberOfEvaluations;
	private Garage garage;
	private Manager manager;	
	private GarageDatabase garageDatabase;
	private Routes route;
	private Reservation reservation;
	private int reservationTime;
	private Car car;
	private PaymentDatabase paymentDatabase;
	
	Driver(GarageDatabase garageDatabase, Car car, PaymentDatabase paymentDatabase){
		this.paymentDatabase = paymentDatabase;
		this.garageDatabase = garageDatabase;
		this.car = car;
	}
	
	public void reserveGarage() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many time do you wanna for your reservation?");
        this.reservationTime = in.nextInt();
        
		this.garage = garageDatabase.searchTheClosestGarage(this);
		
		if(this.garage != null) {
			garageDatabase.disableGarage(garage);	
			garageDatabase.showRoute(this.location, this.garage.getLocation());			 
			
			Scanner system = new Scanner(System.in);
			
			System.out.println("Driver, do you wanna reserv this garage? yes or no!");
	        String answer = system.nextLine(); 
	        
	        if(answer.equals("yes")) {	            
	            System.out.println("You've reserved the garage " + this.garage.getName()); 
	          	reservation = new Reservation(30, garage, garageDatabase, 
	          			this, this.paymentDatabase);        	       	
	        }else {
	        	System.out.println("Ty for your interest");
	        	garageDatabase.enableGarage(garage);
	        }
		}else {
			System.out.println("I'm sorry, there's no garages available for your right now");
		}		
	}
	
	public void cancelReservation() {
		this.reservation.cancelReservation();
	}
	
	public void pay() {
		paymentDatabase.addPayment(new Payment(this));
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
	
	public int getReservationTime() {
		return this.reservationTime;
	}
	
	public Garage getGarage() {
		return this.garage;
	}
	
	public Car getCar() {
		return this.car;
	}
}
