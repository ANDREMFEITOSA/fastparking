package fastparking;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class Payment {
	
	private BigDecimal rentalPrice;
	
	private float serviceFee;
	
	private Host host;
	
	private User user;
	
	public Payment(BigDecimal rentalPrice, float serviceFee, Host host, User user) {
		this.rentalPrice = rentalPrice;
		this.serviceFee = serviceFee;
		this.host = host;
		this.user = user;
	}
	
	public BigDecimal hostPaymentAmount() {
		
		final LocalDateTime timeCheckIn = this.host.getGarage().getTimeCheckIn();
		
		final LocalDateTime timeCheckOut = this.host.getGarage().getTimeCheckOut();
		
		Duration duration = Duration.between(timeCheckOut, timeCheckIn);
		
		final BigDecimal factorTime = new BigDecimal(duration.toMinutes());
		
		final BigDecimal fee = new BigDecimal(this.serviceFee);
		
		return this.rentalPrice.multiply(factorTime).multiply(BigDecimal.ONE.subtract(fee));
	}
	
	public BigDecimal userPaymentAmount() {
		
		final LocalDateTime timeCheckIn = this.host.getGarage().getTimeCheckIn();
		
		final LocalDateTime timeCheckOut = this.host.getGarage().getTimeCheckOut();
		
		Duration duration = Duration.between(timeCheckOut, timeCheckIn);
		
		final BigDecimal factorTime = new BigDecimal(duration.toMinutes());
		
		final BigDecimal fee = new BigDecimal(this.serviceFee);
		
		return this.rentalPrice.multiply(factorTime);
	}

}
