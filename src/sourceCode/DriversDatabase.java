package sourceCode;

import java.util.ArrayList;
import java.util.List;

public class DriversDatabase {
	List<Driver> driversList = new ArrayList<>();
	
	public void add(Driver driver) {
		this.driversList.add(driver);
	}
	
	public void remove(Driver driver) {
		this.driversList.remove(driver);
	}
	
	public boolean isSubscribed(Driver driver) {
		if(driversList.indexOf(driver) != -1) {
			return true;
		}
		
		return false;
	}
}
