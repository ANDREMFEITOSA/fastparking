package sourceCode;

import java.util.ArrayList;
import java.util.List;

public class RefundSolicitationDatabase {
	List<RefundSolicitation> refundSolicitationList = new ArrayList<>();
	
	public void add(RefundSolicitation refund) {
		refundSolicitationList.add(refund);
	}
	
	public void remove() {
		refundSolicitationList.remove(0);
	}
	
	public RefundSolicitation getNext() {
		if(this.refundSolicitationList.size() > 0) {
			return refundSolicitationList.get(0);
		}else {
			return null;
		}
		
	}
}
