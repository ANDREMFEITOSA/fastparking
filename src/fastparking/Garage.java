package fastparking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Garage {
	
	private LocalDateTime timeCheckIn;
	private LocalDateTime timeCheckOut;
	private BigDecimal price;
	private float locationX;
	private float locationY;
	private boolean hostConfirmation;
	private boolean driverConfirmation;
	
	public Garage(float loationX, float locatioY, BigDecimal price) {
		this.locationX = locationX;
		this.locationY = locationY;
		this.price = price;
		hostConfirmation = false;
		driverConfirmation = false;
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
		}
	}

	public float getLocationX() {
		return locationX;
	}

	public float getLocationY() {
		return locationY;
	}	

}
