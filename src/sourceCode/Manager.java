package sourceCode;

import java.util.List;

public class Manager {
	private ComplaintsDatabase complaintDatabase;
	private PaymentDatabase paymentDatabase;
	private RefundDatabase refundDatabase;

	public Manager(ComplaintsDatabase complaintDatabase, PaymentDatabase paymentDatabase,
			RefundDatabase refundDatabase) {
		this.complaintDatabase = complaintDatabase;
		this.paymentDatabase = paymentDatabase;
		this.refundDatabase = refundDatabase;
	}

	public void seeNextComplaint() {
		this.complaintDatabase.seeNextComplaintContent();
	}

	public void refundSolicitation(String description) {

	}

	public void cadastrarHost() {

	}

	public void cadastrarUser() {

	}

	public void desvincularHost() {

	}

	public void desvincularUser() {

	}

}
