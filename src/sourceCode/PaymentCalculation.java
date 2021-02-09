package sourceCode;

import java.math.BigDecimal;

public class PaymentCalculation {
	
	private BigDecimal rentalPrice;
	
	private final BigDecimal serviceFee = new BigDecimal("0.15");
	
	private Garage garage;

	public PaymentCalculation(Garage garage) {
		this.garage = garage;
	}
	
	public BigDecimal hostPaymentAmount() {
		this.rentalPrice = garage.getPrice().multiply(garage.getDuration());
		
		BigDecimal amount = this.rentalPrice.multiply(BigDecimal.ONE.subtract(serviceFee));
		
		return amount;
	}
	
	public BigDecimal driverPaymentAmount() {
		this.rentalPrice = garage.getPrice().multiply(garage.getDuration());
		
		return this.rentalPrice;
		
	}
	
	public BigDecimal getServiceFee() {
		return this.serviceFee;
	}
}
