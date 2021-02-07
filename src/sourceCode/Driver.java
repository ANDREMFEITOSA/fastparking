package sourceCode;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {	
	private String name;
	private String cpf;
	private String carDocument;
	private String location;
	private String card;
	private float score;
	private int numberOfEvaluations;
	private Garage garage;
	private Manager manager;	
	private GarageDatabase garageDatabase;
	private Reservation reservation;
	private int reservationTime;
	private Car car;
	private PaymentDatabase paymentDatabase;
	private RefundDatabase refundDatabase;
	private ComplaintDatabase complaintDatabase;
	private int actualRouteNumber;
	
	public Driver(GarageDatabase garageDatabase, Car car, 
			PaymentDatabase paymentDatabase, RefundDatabase refundDatabase, 
				ComplaintDatabase complaintDatabase){
		this.paymentDatabase = paymentDatabase;
		this.garageDatabase = garageDatabase;
		this.refundDatabase = refundDatabase;
		this.complaintDatabase = complaintDatabase;
		this.car = car;
		this.score = 0;
	}
	
	public void reserveGarage() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many time do you wanna for your reservation?");
        this.reservationTime = in.nextInt();
        
		this.garage = garageDatabase.searchTheClosestGarage(this);
		
		if(this.garage != null) {
			garageDatabase.disableGarage(garage, this);	
			garageDatabase.showRoute(this.location, this.garage.getLocation());			 
			
			this.actualRouteNumber = garageDatabase.getRoute().getRouteNumber();
			
			Scanner system = new Scanner(System.in);
			
			System.out.println("Driver, do you wanna reserv this garage? yes or no!");
	        String answer = system.nextLine(); 
	        
	        if(answer.equals("yes")) {	            
	            System.out.println("You've reserved the garage " + this.garage.getName()); 
	          	reservation = new Reservation(30, garage, garageDatabase, 
	          			this, this.paymentDatabase);        	       	
	        }else {
	        	System.out.println("Ty for your interest");
	        	RoutesManangement.deleteRoute(this.actualRouteNumber);
	        	
	        	if(this.garage.isOpen()) {
	        		garageDatabase.enableGarage(garage, this);
	        	}        	
	        }
		}else {
			System.out.println("I'm sorry, there's no garages available for your right now");
		}		
	}
	
	public void cancelReservation() {
		this.reservation.cancelReservation();
		RoutesManangement.deleteRoute(this.actualRouteNumber);
	}
	
	public void pay() {
		paymentDatabase.addPayment(new Payment(this));
	}
	
	public void confirmCheckIn() {
		this.garage.setTimeCheckIn(this);
		RoutesManangement.deleteRoute(this.actualRouteNumber);
	}
	
	public void ConfirmCheckOut() {
		this.garage.setTimeCheckOut(this);
	}
	
	public void newRefundSolicitation(String reason, int paymentIndex) {
		this.refundDatabase.add(new RefundSolicitation(this, 
				this.paymentDatabase.getPayment(paymentIndex), reason));
	}
	
	public void subimitComplaint(String content) {
		this.complaintDatabase.add(new Complaint(this, content));
	}
	
	public void evaluate(int evaluation) {
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
	
	public String getCreditCard() {
		return this.card;
	}
}
