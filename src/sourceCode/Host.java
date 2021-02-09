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
		
		this.database.hostsDatabase.add(this);
	}

	public void enableGarage() {
		try {
			this.subscriptionVerification();
			this.database.garageDatabase.enableGarage(this.garage, this);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void disableGarage() {
		try {
			this.subscriptionVerification();
			this.database.garageDatabase.disableGarage(this.garage, this);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void confirmCheckIn() {
		try {
			this.subscriptionVerification();
			this.garage.setTimeCheckIn(this);
			this.disableGarage();
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void confirmCheckOut(int evaluation) {
		try {
			this.subscriptionVerification();
			this.garage.setTimeCheckOut(this, evaluation);
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Garage getGarage() {
		try {
			this.subscriptionVerification();
			return this.garage;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void subimitComplaint(String content) {
		try {
			this.subscriptionVerification();
			this.database.complaintsDatabase.add(new Complaint(this, content));
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void evaluate(int evaluation) {
		try {
			this.subscriptionVerification();
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
			this.subscriptionVerification();
			return this.account;
		} catch (SubscriptionNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void subscriptionVerification () throws SubscriptionNotFoundException{
		if(!this.database.hostsDatabase.isSubscribed(this)) {
			throw new SubscriptionNotFoundException(this.name + 
					" You're not subscribed in our platform.");
		}
	}
}
