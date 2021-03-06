package sourceCode;

import java.math.BigDecimal;
import java.time.Duration;
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
	private BigDecimal width;
	private BigDecimal length;
	private Host host;
	private Driver driver;
	private boolean isOpen;
	
	public Garage(String location, String name, BigDecimal length, BigDecimal width) {
		this.location = location;
		this.hostConfirmation = false;
		this.driverConfirmation = false;
		this.name = name;
		this.searchesTime = new ArrayList<>();
		driverIsInTheGarage = false;
		closeTime = null;
		this.width = width;
		this.length = length;
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

	public void setTimeCheckIn(UsuariosComAcessoAGaragem object) {
		if(object instanceof Driver) {
			Driver driver = (Driver) object;
			this.driver = driver;
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

	public void setTimeCheckOut(Object object, int evaluation) {
		if(object instanceof Driver) {
			this.getHost().evaluate(evaluation);
			driverConfirmation = true;
			driverIsInTheGarage = false;
		}
		
		if(object instanceof Host) {
			hostConfirmation = true;
			this.getDriver().evaluate(evaluation);
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
		if(searchesPerMonth() < 3) {
			this.status = "gold";
		}else if(searchesPerMonth() >= 3 && searchesPerMonth() < 5) {
			this.status = "platinum";
		}else if(searchesPerMonth() > 5) {
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
	
	public BigDecimal getDuration(){		
		Duration duration = Duration.between(timeCheckIn, timeCheckOut);
		
		return BigDecimal.valueOf(duration.toSeconds());
	}
	
	public void setDimensions(BigDecimal width, BigDecimal length) {
		this.width = width;
		this.length = length;
	}
	
	public BigDecimal getWidth() {
		return this.width;
	}
	
	public BigDecimal getLength() {
		return this.length;
	}
	
	public Host getHost() {
		return this.host;
	}
	
	public Driver getDriver() {
		return this.driver;
	}
	
	public void setHost(Host host) {
		this.host = host;
	}
	
	public void open() {
		this.isOpen = true;
	}
	
	public void close() {
		this.isOpen = false;
	}
	
	public boolean isOpen() {
		return this.isOpen;
	}
}

