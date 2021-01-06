package fastparking;

public class Host {
	
	private String name;
	private String cpf;
	private String proofOfAddress;
	private String account;
	private Garage garage;
	private int score;
	
	
	
	public Host(String name, String cpf, String proofOfAddress, String account, Garage garage, int score) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.proofOfAddress = proofOfAddress;
		this.account = account;
		this.garage = garage;
		this.score = score;
	}

	public void enableGarage() {
		
		this.garage.enable();
		
	}
	
	public void disableGarage() {
		
		this.garage.disable();;
		
	}
	
	public void confirCheckIn() {
		
	}
	
	public void confirmarCheckOut() {
		
	}
	
	public void enviarReclamacao() {
		
	}
	
	public void avaliarUser() {
		
	}

}
