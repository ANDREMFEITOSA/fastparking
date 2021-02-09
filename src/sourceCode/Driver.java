package sourceCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {	
	private String name;
	private String location;
	private String card;
	private BigDecimal score;
	private int numberOfEvaluations;
	private Garage garage;
	private Reservation reservation;
	private int reservationTime;
	private Car car;
	private int actualRouteNumber;
	private Database database;
	private BigDecimal credit;
	
	public Driver(Car car, Database database, String name){
		this.database = database;
		this.car = car;
		this.score = new BigDecimal("0");
		this.name = name;
		this.credit = new BigDecimal("0");
		
		database.driversDatabase.add(this);
	}
	
	public void reserveGarage () {
		try {
			this.isSubscribed();
			
			Scanner in = new Scanner(System.in);
			
			System.out.println(this.name + ", how much time do you wanna for your reservation?");
	        this.reservationTime = in.nextInt();
	        
			this.garage = database.garageDatabase.searchTheClosestGarage(this);
			
			if(this.garage != null) {
				database.garageDatabase.disableGarage(garage, this);	
				database.garageDatabase.showRoute(this.location, this.garage.getLocation());			 
				
				this.actualRouteNumber = database.garageDatabase.getRoute().getRouteNumber() - 1;
				
				Scanner system = new Scanner(System.in);
				
				System.out.println(this.name + ", do you wanna reserv this garage? yes or no!");
		        String answer = system.nextLine(); 
		        
		        if(answer.equals("yes")) {	            
		            System.out.println("You've reserved the garage " + this.garage.getName()); 
		          	reservation = new Reservation(15, garage, this.database, this);        	       	
		        }else {
		        	System.out.println("Ty for your interest");
		        	RoutesManangement.deleteRoute(this.actualRouteNumber);
		        	
		        	if(this.garage.isOpen()) {
		        		this.database.garageDatabase.enableGarage(garage, this);
		        	}     
		        	
		        	this.garage = null;
		        }
			}else {
				System.out.println("I'm sorry, there's no garages available for your right now");
			}
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void cancelReservation() {
		try {
			this.isSubscribed();
			
			this.reservation.cancelReservation();
			RoutesManangement.deleteRoute(this.actualRouteNumber);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void pay() {
		try {
			this.isSubscribed();
			this.database.paymentDatabase.addPayment(new Payment(this));
			this.credit = new BigDecimal("0");
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void confirmCheckIn() {
		try {
			this.isSubscribed();
			this.garage.setTimeCheckIn(this);
			RoutesManangement.deleteRoute(this.actualRouteNumber);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void ConfirmCheckOut(int evaluation) {
		try {
			this.isSubscribed();
			this.garage.setTimeCheckOut(this, evaluation);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void newRefundSolicitation(String reason, int paymentIndex) {
		try {
			this.isSubscribed();
			
			this.database.refundDatabase.add(new RefundSolicitation(this, 
					this.database.paymentDatabase.getPayment(paymentIndex), reason));
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void subimitComplaint(String content) {
		try {
			this.isSubscribed();
			this.database.complaintsDatabase.add(new Complaint(this, content));
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void evaluate(int evaluation) {
		try {
			this.isSubscribed();
			numberOfEvaluations++;
			
			BigDecimal actualScorePlusNewScore = score.add(new BigDecimal(String.valueOf(evaluation)));
			
			BigDecimal numberOfEvaluation = new BigDecimal(String.valueOf(numberOfEvaluations));
			
			score = actualScorePlusNewScore.divide(numberOfEvaluation);
					

		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getLocation() {
		try {
			this.isSubscribed();
			return location;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		
		return null;
	}
	
	public void setLocation(String location) {
		try {
			this.isSubscribed();
			this.location = location;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getReservationTime() {
		try {
			this.isSubscribed();
			return this.reservationTime;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public Garage getGarage() {
		try {
			this.isSubscribed();
			return this.garage;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public Car getCar() {
		try {
			this.isSubscribed();
			return this.car;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String getCreditCard() {
		try {
			this.isSubscribed();
			return this.card;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public int getActualRouteNumber() {
		try {
			this.isSubscribed();
			return this.actualRouteNumber;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public void setCar(Car car) {
		try {
			this.isSubscribed();
			this.car = car;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void isSubscribed () throws SubscriptionNotFoundException{
		if(!this.database.driversDatabase.isSubscribed(this)) {
			throw new SubscriptionNotFoundException(this.name + 
					" You're not subscribed in our platform.");
		}
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getScore() {
		return this.score;
	}
	
	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}
	
	public BigDecimal getCredit() {
		return this.credit;
	}
}
