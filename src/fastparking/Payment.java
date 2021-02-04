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
	}
	
	public double getDuration(){
		
		LocalDateTime timeCheckIn = this.host.getGarage().getTimeCheckIn();
		
		LocalDateTime timeCheckOut = this.host.getGarage().getTimeCheckOut();
		
		Duration duration = Duration.between(timeCheckOut, timeCheckIn);
		
		return duration.toHours();
	}
	
	public BigDecimal getRentalPrice() {
		this.rentalPrice = this.host.getGarage().getPrice();
		return rentalPrice;
	}
	
	public String hostPaymentAmount(BigDecimal rentalPrice, double duration) {
		
		
		BigDecimal factorTime = new BigDecimal(duration);
		
		BigDecimal amount = rentalPrice.multiply(factorTime).multiply(BigDecimal.ONE.subtract(serviceFee));
		
		return NumberFormat.getCurrencyInstance().format(amount);
	}
	
	public String driverPaymentAmount(BigDecimal rentalPrice, double duration) {
		
		BigDecimal factorTime = new BigDecimal(duration);
		
		BigDecimal amount = rentalPrice.multiply(factorTime);
		
		return NumberFormat.getCurrencyInstance().format(amount);
	}
}
