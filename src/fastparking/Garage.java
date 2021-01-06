package fastparking;

import java.math.BigDecimal;

public class Garage {
	
	private boolean availability;
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
	
	

}
