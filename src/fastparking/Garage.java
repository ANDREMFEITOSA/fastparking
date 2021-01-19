package fastparking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Garage {
	
	private LocalDateTime timeCheckIn;
	private LocalDateTime timeCheckOut;
	private BigDecimal price;
	private float locationX;
	private float locationY;
	
	public Garage(float loationX, float locatioY) {
		this.locationX = locationX;
		this.locationY = locationY;
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

	public void setTimeCheckIn(LocalDateTime timeCheckIn) {
		this.timeCheckIn = timeCheckIn;
	}

	public LocalDateTime getTimeCheckOut() {
		return timeCheckOut;
	}

	public void setTimeCheckOut(LocalDateTime timeCheckOut) {
		this.timeCheckOut = timeCheckOut;
	}


	public float getLocationX() {
		return locationX;
	}


	public float getLocationY() {
		return locationY;
	}	

}
