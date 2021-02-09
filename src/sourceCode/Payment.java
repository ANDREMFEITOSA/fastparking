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
			this.driver = (Driver) obj;
			this.valueDriver = paymentCalculation.driverPaymentAmount().
					subtract(this.driver.getCredit());
			this.valueHost = paymentCalculation.hostPaymentAmount();
			this.host = this.driver.getGarage().getHost();
			}else if(obj instanceof Verification){
			PaymentCalculation paymentCalculation = new PaymentCalculation(((Verification) obj).getDriver().getGarage());
			
			this.driver = ((Verification) obj).getDriver();
			this.host = this.driver.getGarage().getHost();
			this.valueDriver = this.driver.getGarage().getPrice().divide(new BigDecimal("2"));
			this.valueHost = this.valueDriver.multiply(BigDecimal.ONE.
					subtract(paymentCalculation.getServiceFee()));
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
	
	public Driver getDriver() {
		return this.driver;
	}
}
