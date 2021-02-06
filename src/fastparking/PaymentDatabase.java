package fastparking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentDatabase {
	
	private List<Payment> paymentList;
	
	public PaymentDatabase() {
		this.paymentList = new ArrayList<>();
	}
	
	public void addPayment(Payment payment) {
		this.paymentList.add(payment);
	}
	
	public void removePayment(Payment payment) {
		this.paymentList.remove(payment);
	}
}
