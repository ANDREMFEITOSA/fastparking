package tests;

import static org.junit.jupiter.api.Assertions.*;
import sourceCode.*;
import org.junit.jupiter.api.Test;

class ComplaintsDatabaseTest {

	@Test
	void complaintDatabaseTest() {
		Database database = new Database();
		Driver driver = new Driver(new Car("JTDZN3EU0E3298500"), database, "");
		driver.subimitComplaint("The platform is too slow");
		
		Garage garage = new Garage("", "", null, null);
		
		Host host = new Host("", "", garage, database);
		
		host.subimitComplaint("The platform aesthetic isn'n good");
		
		database.complaintsDatabase.seeNextComplaintContent();
		
		database.complaintsDatabase.removeComplaint();
		
		database.complaintsDatabase.seeNextComplaintContent();
	}

}
