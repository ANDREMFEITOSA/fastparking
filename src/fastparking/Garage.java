package fastparking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Garage {
	
	private LocalDateTime timeCheckIn;
	private LocalDateTime timeCheckOut;
	private LocalDateTime closeTime;
	private List<Integer> searchesTime;
	private BigDecimal price;
	private String status;
	private String location;
	private String name;
	private boolean hostConfirmation;
	private boolean driverConfirmation;
	private boolean driverIsInTheGarage;
	
	
	public Garage(String location, String name) {
		this.location = location;
		this.hostConfirmation = false;
		this.driverConfirmation = false;
		this.name = name;
		this.searchesTime = new ArrayList<>();
		driverIsInTheGarage = false;
		closeTime = null;
	}
	
	public BigDecimal getPrice() {
		if(this.getStatus().equals("gold")) {
			this.price = new BigDecimal("5");
		}
		
		if(this.getStatus().equals("platinum")) {
			this.price = new BigDecimal("10");
		}
		
		if(this.getStatus().equals("black")) {
			this.price = new BigDecimal("20");
		}
		
		return this.price;
	}
	
	public LocalDateTime getTimeCheckIn() {
		return timeCheckIn;
	}

	public void setTimeCheckIn(Object object) {
		if(object instanceof Driver) {
			driverConfirmation = true;
			driverIsInTheGarage = true;
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
			driverIsInTheGarage = false;
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
	}
	
	public void newSearch(){
		LocalDateTime searchTime = LocalDateTime.now();
		searchesTime.add(searchTime.getDayOfYear());
	}
	
	private boolean isLeapYear(int year) {
		if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
			return true;
		}
		else{
			return false;
		}
	}
	
	private int searchesPerMonth() {
		LocalDateTime today = LocalDateTime.now();
		int dayOfYear = today.getDayOfYear();
		
		for(int i = 0; i < searchesTime.size(); i++) {
			if(dayOfYear >= searchesTime.get(i) && (dayOfYear - searchesTime.get(i)) > 30) {
				searchesTime.remove(i);
			}
			
			if(dayOfYear < searchesTime.get(i)){
				if(this.isLeapYear(today.getYear() - 1)) {
					dayOfYear += 366;
				}else {
					dayOfYear += 365;
				}
				
				if(dayOfYear - searchesTime.get(i) > 30) {
					searchesTime.remove(i);
				}
			}
		}
		
		return searchesTime.size();
	}

	public String getStatus() {
		if(searchesPerMonth() < 160) {
			this.status = "gold";
		}else if(searchesPerMonth() >= 160 && searchesPerMonth() < 240) {
			this.status = "platinum";
		}else if(searchesPerMonth() > 240) {
			this.status = "black";
		}
		
		return this.status;
	}
	
	public boolean driverIsInTheGarage() {
		return this.driverIsInTheGarage;
	}
	
	public void setCloseTime(int operatingTime) {
		LocalDateTime now = LocalDateTime.now();
		this.closeTime = now.plusSeconds(operatingTime);
	}
	
	public LocalDateTime getCloseTime() {
		return this.closeTime;
	}
}

