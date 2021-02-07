package sourceCode;

import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

public class Reservation {

	Timer timer;
	Garage garage;
	GarageDatabase garageDatabase;

	public Reservation(int seconds, Garage garage, GarageDatabase garageDatabase, Driver driver,
			PaymentDatabase paymentDatabase) {
		this.garage = garage;
		this.garageDatabase = garageDatabase;
		this.timer = new Timer();
		this.timer.schedule(new Verification(garage, garageDatabase, driver, paymentDatabase), seconds * 1000);
	}

	public void cancelReservation() {
		System.out.println("You've cancel the reservation");
		this.garageDatabase.enableGarage(this.garage, this);
		timer.cancel();
	}

	class Verification extends TimerTask {
		Garage garage;
		GarageDatabase garageDatabase;
		Driver driver;
		PaymentDatabase paymentDatabase;

		public Verification(Garage garage, GarageDatabase garageDatabase, Driver driver,
				PaymentDatabase paymentDatabase) {
			this.garage = garage;
			this.driver = driver;
			this.garageDatabase = garageDatabase;
			this.paymentDatabase = paymentDatabase;
		}

		public void run() {
			if (this.garage.driverIsInTheGarage()) {
				System.out.println("Drive is in the garage");
			} else {
				if (this.garage.isOpen()) {
					this.garageDatabase.enableGarage(this.garage, this);
				}

				this.paymentDatabase.addPayment(new Payment(this));

				System.out.println("Your reservation time run out! " + "You're gonna be charged: R$ "
						+ this.garage.getPrice().divide(new BigDecimal("2")));
				
				RoutesManangement.deleteRoute(this.driver.getActualRouteNumber());
			}

		}

		public Driver getDriver() {
			return this.driver;
		}

	}

}
