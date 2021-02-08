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
	private Reservation reservation;
	private int reservationTime;
	private Car car;
	private int actualRouteNumber;
	private Database database;
	
	public Driver(Car car, Database database){
		this.database = database;
		this.car = car;
		this.score = 0;
	}
	
	public void reserveGarage() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many time do you wanna for your reservation?");
        this.reservationTime = in.nextInt();
        
		this.garage = database.garageDatabase.searchTheClosestGarage(this);
		
		if(this.garage != null) {
			database.garageDatabase.disableGarage(garage, this);	
			database.garageDatabase.showRoute(this.location, this.garage.getLocation());			 
			
			this.actualRouteNumber = database.garageDatabase.getRoute().getRouteNumber() - 1;
			
			Scanner system = new Scanner(System.in);
			
			System.out.println("Driver, do you wanna reserv this garage? yes or no!");
	        String answer = system.nextLine(); 
	        
	        if(answer.equals("yes")) {	            
	            System.out.println("You've reserved the garage " + this.garage.getName()); 
	          	reservation = new Reservation(30, garage, this.database, this);        	       	
	        }else {
	        	System.out.println("Ty for your interest");
	        	RoutesManangement.deleteRoute(this.actualRouteNumber);
	        	
	        	if(this.garage.isOpen()) {
	        		this.database.garageDatabase.enableGarage(garage, this);
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
		this.database.paymentDatabase.addPayment(new Payment(this));
	}
	
	public void confirmCheckIn() {
		this.garage.setTimeCheckIn(this);
		RoutesManangement.deleteRoute(this.actualRouteNumber);
	}
	
	public void ConfirmCheckOut() {
		this.garage.setTimeCheckOut(this);
	}
	
	public void newRefundSolicitation(String reason, int paymentIndex) {
		this.database.refundDatabase.add(new RefundSolicitation(this, 
				this.database.paymentDatabase.getPayment(paymentIndex), reason));
	}
	
	public void subimitComplaint(String content) {
		this.database.complaintsDatabase.add(new Complaint(this, content));
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

	public int getActualRouteNumber() {
		return this.actualRouteNumber;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void isSubscribed () throws DriverUnsubscribed {
		
	}
}
