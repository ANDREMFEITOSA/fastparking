package sourceCode;

import java.math.BigDecimal;

import sourceCode.Reservation.Verification;

public class Payment {
	
	private BigDecimal valueDriver;
	private BigDecimal valueHost;
	private Driver driver;
	private Host host;
	
	public Payment(Object obj){
		if(obj instanceof Driver) {
			PaymentCalculation paymentCalculation = new PaymentCalculation(((Driver) obj).getGarage());
			this.valueDriver = paymentCalculation.driverPaymentAmount();
			this.valueHost = paymentCalculation.hostPaymentAmount();
			this.host = ((Driver) obj).getGarage().getHost();
			this.driver = ((Driver) obj);
		}else {
			PaymentCalculation paymentCalculation = new PaymentCalculation(((Verification) obj).getDriver().getGarage());
			
			this.driver = ((Verification) obj).getDriver();
			this.host = ((Verification) obj).getDriver().getGarage().getHost();
			this.valueDriver = ((Verification) obj).getDriver().getGarage()
					.getPrice().divide(new BigDecimal("2"));
			this.valueHost = this.valueDriver
					.multiply(BigDecimal.ONE.subtract(paymentCalculation.getServiceFee()));
		}
	}
	
	public BigDecimal getValueHost() {
		return this.valueHost;
	}
	
	public BigDecimal getValueDriver() {
		return this.valueDriver;
	}
	
	public String getDriverCreditCard() {
		return this.driver.getCreditCard();
	}
	
	public String getHostBankAccount() {
		return this.host.getBankAccount();
	}
}
