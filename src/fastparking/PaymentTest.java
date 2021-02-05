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
		Garage garage = new Garage("Antônio Barreto", "Uata");
		Driver driver = new Driver(garageDatabase);
		Host host = new Host("João", "000.000.000-00", "xxx", "000000", garage, 10);
		
		BigDecimal serviceFee = BigDecimal.valueOf(0.05);
		
		Payment payment = new Payment(host, driver, serviceFee);
		
		String driverValue = NumberFormat.getCurrencyInstance().format(payment.driverPaymentAmount(BigDecimal.valueOf(2.5)));
		String hostValue = NumberFormat.getCurrencyInstance().format(payment.hostPaymentAmount(BigDecimal.valueOf(2.5)));
		
		Assertions.assertEquals("R$ 12,50", driverValue);
		Assertions.assertEquals("R$ 11,88", hostValue);
	}
}
