package sourceCode;

import java.util.ArrayList;
import java.util.List;

public class ComplaintDatabase {
	List<Complaint> complaints = new ArrayList<>();
	
	public void add(Complaint complaint){
		complaints.add(complaint);
	}
	
	public void removeComplaint(){
		complaints.remove(0);
	}
	
	public void seeNextComplaintContent() {
		complaints.get(0).showContent();
	}
	
	public void getNextComplainer() {
		complaints.get(0).getComplainer();
	}
}
