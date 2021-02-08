package sourceCode;

import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

public class Reservation {

	private Timer timer;
	private Garage garage;
	private Database database;
	
	public Reservation(int seconds, Garage garage, Database database, Driver driver) {
		this.garage = garage;
		this.timer = new Timer();
		this.timer.schedule(new Verification(garage, database, driver), seconds * 1000);
	}

	public void cancelReservation() {
		System.out.println("You've cancel the reservation");
		this.database.garageDatabase.enableGarage(this.garage, this);
		timer.cancel();
	}

	class Verification extends TimerTask {
		Garage garage;
		Driver driver;
		Database database;

		public Verification(Garage garage, Database database, Driver driver) {
			this.database = database;
			this.garage = garage;
			this.driver = driver;
		}

		public void run() {
			if (this.garage.driverIsInTheGarage()) {
				System.out.println("Drive is in the garage");
			} else {
				if (this.garage.isOpen()) {
					this.database.garageDatabase.enableGarage(this.garage, this);
				}

				this.database.paymentDatabase.addPayment(new Payment(this));
				
				System.out.println(this.driver.getName() + ", Your reservation time run out! " 
						+ "You're gonna be charged: R$ "
						+ this.garage.getPrice().divide(new BigDecimal("2")));				
				
			}
			
			RoutesManangement.deleteRoute(this.driver.getActualRouteNumber());
		}

		public Driver getDriver() {
			return this.driver;
		}

	}

}
