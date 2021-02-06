package fastparking;

import java.math.BigDecimal;

public class Payment {
	
	private BigDecimal valueDriver;
	private BigDecimal valueHost;
	private Driver driver;
	private Host host;
	
	public Payment(Object obj){
		if(obj instanceof Driver) {
			PaymentCalculation paymentCalculation = new PaymentCalculation(((Driver) obj).getGarage());
			this.valueDriver = paymentCalculation.driverPaymentAmount();
			this.valueHost = paymentCalculation.hostPaymentAmount();
			this.host = ((Driver) obj).getGarage().getHost();
			this.driver = ((Driver) obj);
		}
	}
}
