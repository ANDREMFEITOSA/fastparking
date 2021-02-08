package sourceCode;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class HostsDatabase {
	List<Host> hostsList = new ArrayList<>();
	
	public void add(Host host) {
		this.hostsList.add(host);
	}
	
	public void remove(Host host) {
		this.hostsList.remove(host);
	}
	
	public boolean isSubscribed(Host host) {
		if(hostsList.indexOf(host) != -1) {
			return true;
		}
		
		return false;
	}
=======
	public void remove(Host host) {
		// TODO Auto-generated method stub
		
	}

>>>>>>> ccff4a0c19c2367a60e6b02433efb1ec40cd13a5
}
