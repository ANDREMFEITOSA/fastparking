package fastparking;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;

public class PaymentCalculation {
	
	private BigDecimal rentalPrice;
	
	private final BigDecimal serviceFee = new BigDecimal("0.15");

	public PaymentCalculation(Garage garage) {
	
		this.rentalPrice = garage.getPrice().multiply(garage.getDuration());
	}
	
	public BigDecimal hostPaymentAmount() {
		
		BigDecimal amount = this.rentalPrice.multiply(BigDecimal.ONE.subtract(serviceFee));
		
		return amount;
	}
	
	public BigDecimal driverPaymentAmount() {
		
		return this.rentalPrice;
		
	}
	
	public BigDecimal getServiceFee() {
		return this.serviceFee;
	}
}
