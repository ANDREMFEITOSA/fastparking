package sourceCode;

import java.util.ArrayList;
import java.util.List;

public class RefundDatabase {
	List<RefundSolicitation> refundSolicitationList = new ArrayList<>();
	
	public void add(RefundSolicitation refund) {
		refundSolicitationList.add(refund);
	}
	
	public void remove() {
		refundSolicitationList.remove(0);
	}
	
	public RefundSolicitation getNext() {
		return refundSolicitationList.get(0);
	}
}
