package fastparking;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentTest {

	@Test
	void hostPaymentAmountTest() {
		
		Routes routes = new Routes();
		GarageDatabase garageDatabase = new GarageDatabase(routes);
		Garage garage = new Garage("Antônio Barreto", "Uata", new BigDecimal("1000"), new BigDecimal("1000"));
		PaymentDatabase paymentDatabase = new PaymentDatabase();
		Driver driver = new Driver(garageDatabase, new Car("JTDZN3EU0E3298500"), paymentDatabase);
		Host host = new Host("João", "000.000.000-00", "xxx", "000000", garage, 10);
		
		BigDecimal serviceFee = BigDecimal.valueOf(0.05);
		
		PaymentCalculation payment = new PaymentCalculation(garage);
		
		String driverValue = NumberFormat.getCurrencyInstance().format(payment.driverPaymentAmount());
		String hostValue = NumberFormat.getCurrencyInstance().format(payment.hostPaymentAmount());
		
		Assertions.assertEquals("R$ 12,50", driverValue);
		Assertions.assertEquals("R$ 11,88", hostValue);
	}
}
