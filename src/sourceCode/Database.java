package sourceCode;

public class Database {
	public ComplaintsDatabase complaintsDatabase = new ComplaintsDatabase();
	public DriversDatabase driversDatabase = new DriversDatabase();
	public RouteCalculation routeCalculation = new RouteCalculation();
	public GarageDatabase garageDatabase = new GarageDatabase(routeCalculation);
	public PaymentDatabase paymentDatabase = new PaymentDatabase();
	public RefundDatabase refundDatabase = new RefundDatabase();
	public HostsDatabase hostsDatabase = new HostsDatabase();
}
