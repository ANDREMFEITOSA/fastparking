package sourceCode;

import java.math.BigDecimal;

public class Host {
	
	private String name;
	private String account;
	private Garage garage;
	private int numberOfEvaluations;
	private BigDecimal score;
	private Database database;
	
	public Host(String name, String account, Garage garage, Database database) {
		this.name = name;
		this.account = account;
		this.garage = garage;
		this.database = database;
		this.score = new BigDecimal("0");
		this.garage.setHost(this);
	}

	public void enableGarage() {
		try {
			this.isSubscribed();
			this.database.garageDatabase.enableGarage(this.garage, this);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void disableGarage() {
		try {
			this.isSubscribed();
			this.database.garageDatabase.disableGarage(this.garage, this);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void confirmCheckIn() {
		try {
			this.isSubscribed();
			this.garage.setTimeCheckIn(this);
			this.disableGarage();
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void confirmCheckOut(int evaluation) {
		try {
			this.isSubscribed();
			this.garage.setTimeCheckOut(this, evaluation);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
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
	
	public String getBankAccount() {
		try {
			this.isSubscribed();
			return this.account;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void isSubscribed () throws SubscriptionNotFoundException{
		if(!this.database.hostsDatabase.isSubscribed(this)) {
			throw new SubscriptionNotFoundException(this.name + 
					" You're not subscribed in our platform.");
		}
	}
}
