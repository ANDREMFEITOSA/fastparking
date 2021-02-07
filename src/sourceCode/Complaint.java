package sourceCode;

public class Complaint {
	private Object complainer;
	private String content;
	
	public Complaint(Object obj, String content) {
		this.complainer = obj;
		this.content = content;
	}
	
	public void showContent() {
		System.out.println(content);
	}
	
	public Object getComplainer() {
		return this.complainer;
	}
}
