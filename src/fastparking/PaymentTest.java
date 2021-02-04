package fastparking;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentTest {

	@Test
	void hostPaymentAmountTest() {
		
		Garage garage = new Garage("Antônio Barreto", "Uata");
		Driver driver = new Driver();
		Host host = new Host("João", "000.000.000-00", "xxx", "000000", garage, 10);
		
		BigDecimal serviceFee = BigDecimal.valueOf(0.05);
		BigDecimal rentalPrice = BigDecimal.valueOf(5);
		Payment payment = new Payment(host, driver, serviceFee);
		
		Assertions.assertEquals("R$ 10,00", payment.driverPaymentAmount(rentalPrice, 2));
		Assertions.assertEquals("R$ 9,50", payment.hostPaymentAmount(rentalPrice, 2));
	}

}
