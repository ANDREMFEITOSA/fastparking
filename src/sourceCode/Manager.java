package sourceCode;

public class Manager {
	private Database database;
	
	public Manager(Database database) {
		this.database = database;
	}

	public void seeNextComplaint() {
		this.database.complaintsDatabase.seeNextComplaintContent();
	}

	public void authorizeRefund(Payment payment) {
		payment.getDriver().setCredit(payment.getValueDriver());
	}

	public void unsubscribeDriver(Driver driver) {
		this.database.driversDatabase.remove(driver);
	}
	
	public void unsubscribeHost(Host host) {
		this.database.hostsDatabase.remove(host);
	}

}
