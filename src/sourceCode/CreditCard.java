package sourceCode;

public class CreditCard {
	private int number;
	private String name;
	private int cvv;
	private int expirationDate;
	private int cpf;
	
	public CreditCard(int number, String name, int cvv, int expirationDate, int cpf) {
		this.number = number;
		this.name = name;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
		this.cpf = cpf;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getCvv() {
		return cvv;
	}

	public int getExpirationDate() {
		return expirationDate;
	}
	
	public int getCpf() {
		return cpf;
	}

}
