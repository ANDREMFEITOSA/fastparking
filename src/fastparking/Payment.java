package fastparking;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;

public class Payment {
	
	private BigDecimal rentalPrice;
	
	private BigDecimal serviceFee;
	
	private Host host;
	
	private Driver driver;
	
	public Payment(Host host, Driver driver, BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
		this.host = host;
		this.driver = driver;
		this.rentalPrice = this.host.getGarage().getPrice();
	}
	
	public BigDecimal getDuration(){
		
		LocalDateTime timeCheckIn = this.host.getGarage().getTimeCheckIn();
		
		LocalDateTime timeCheckOut = this.host.getGarage().getTimeCheckOut();
		
		Duration duration = Duration.between(timeCheckOut, timeCheckIn);
		
		return BigDecimal.valueOf(duration.toHours());
	}
	
	public BigDecimal hostPaymentAmount(BigDecimal duration) {
		
		BigDecimal amount = rentalPrice.multiply(duration).multiply(BigDecimal.ONE.subtract(serviceFee));
		
		return amount;
	}
	
	public BigDecimal driverPaymentAmount(BigDecimal duration) {
		
		BigDecimal amount = rentalPrice.multiply(duration);
		
		return amount;
	}
	
}
