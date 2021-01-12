package fastparking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Garage {
	
	private boolean availability;
	private boolean occupation; //variável para indicar a ocupação ou não da garagem
	private LocalDateTime timeCheckIn; //variável para hora do check in
	private LocalDateTime timeCheckOut; //variável para hora do check out
	private BigDecimal price;
	private String location;
	
	
	
	public boolean getAvailability() {
		return availability;
	}
	
	public void enable() {
		this.availability = true;
	}
	
	public void disable() {
		this.availability = false;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	
	

}
