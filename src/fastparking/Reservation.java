package fastparking;

import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

public class Reservation {
	
	Timer timer;
	Garage garage;
	GarageDatabase garageDatabase;
	
	public Reservation(int seconds, Garage garage, GarageDatabase garageDatabase) {
		this.garage = garage;
		this.garageDatabase = garageDatabase;
		this.timer = new Timer();
		this.timer.schedule(new Verification(garage, garageDatabase), seconds*1000);
	}
	
	public void cancelReservation() {
		System.out.println("You've cancel the reservation");
		this.garageDatabase.enableGarage(this.garage);
		timer.cancel();
	}

	class Verification extends TimerTask {
		Garage garage;
		GarageDatabase garageDatabase;
		
		public Verification(Garage garage, GarageDatabase garageDatabase) {
			this.garage = garage;
			this.garageDatabase = garageDatabase;
		}
		
		public void run() {
			if(this.garage.driverIsInTheGarage()) {				
				System.out.println("Drive is in the garage");
			}else {
				this.garageDatabase.enableGarage(this.garage);
				System.out.println("Your reservation time run out! "
						+ "You're gonna be charged: R$ " + 
						this.garage.getPrice().divide(new BigDecimal("2")));
			}
			
			timer.cancel(); 
		}
		
	}
	
}
		
	

