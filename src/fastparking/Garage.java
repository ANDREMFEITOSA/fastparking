package fastparking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Garage {
	
	private LocalDateTime timeCheckIn;
	private LocalDateTime timeCheckOut;
	private BigDecimal price;
	private String location;
	private boolean hostConfirmation;
	private boolean driverConfirmation;
	private String name;
	
	public Garage(String location, BigDecimal price, String name) {
		this.location = location;
		this.price = price;
		hostConfirmation = false;
		driverConfirmation = false;
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public LocalDateTime getTimeCheckIn() {
		return timeCheckIn;
	}

	public void setTimeCheckIn(Object object) {
		if(object instanceof Driver) {
			driverConfirmation = true;
		}
		
		if(object instanceof Host) {
			hostConfirmation = true;
		}
		
		if(hostConfirmation && driverConfirmation) {
			this.timeCheckIn = LocalDateTime.now();
			hostConfirmation = false;
			driverConfirmation = false;
		}		
	}

	public LocalDateTime getTimeCheckOut() {
		return timeCheckOut;
	}

	public void setTimeCheckOut(Object object) {
		if(object instanceof Driver) {
			driverConfirmation = true;
		}
		
		if(object instanceof Host) {
			hostConfirmation = true;
		}
		
		if(hostConfirmation && driverConfirmation) {
			this.timeCheckOut = LocalDateTime.now();
			hostConfirmation = false;
			driverConfirmation = false;
		}
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	};

}
