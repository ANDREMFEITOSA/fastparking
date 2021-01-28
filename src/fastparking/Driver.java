package fastparking;

import java.util.ArrayList;

public class Driver {	
	private String name;
	private String cpf;
	private String carDocument;
	private CreditCard card;
	private float score;
	private int numberOfEvaluations;
	private Garage garage;
	private Manager manager;
	
	public void reserveGarage() {
		
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
}
