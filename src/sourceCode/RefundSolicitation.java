package sourceCode;

public class RefundSolicitation {
	Driver driver;
	Payment payment;
	String reason;
	
	public RefundSolicitation(Driver driver, Payment payment, String reason) {
		this.driver = driver;
		this.payment = payment;
		this.reason = reason;
	}
	
	public void showReason() {
		System.out.println(reason);
	}
}
