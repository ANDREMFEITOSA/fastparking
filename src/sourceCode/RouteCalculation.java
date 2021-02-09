package sourceCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculation {
	private int routeNumber = 1;
	
	public void calculatingRoute(String origin, String destination) {
		String line1 = "<iframe";
		String line2 = "  width=\"900\"";
		String line3 = "  height=\"500\"";
		String line4 = "  frameborder=\"0\" style=\"border:0\"";
		String line5 = "  src=\"https://www.google.com/maps/embed/v1/directions?"
				+ "key=AIzaSyDqGIMchOeXPAlfe1qzQjAlUt5QVf6lh8s&"
				+ "origin=" + origin + "&destination=" + destination + "\" "
				+ "allowfullscreen>";
		String line6 = "</iframe>";
		
		List<String> lines = new ArrayList<>();
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);
		lines.add(line4);
		lines.add(line5);
		lines.add(line6);
		
		String fileName = "route";
		fileName += routeNumber + ".html";
		
		File htmlFile = new File(fileName);
		
		try {
			PrintStream writer = new PrintStream(htmlFile);
			
			for(int i = 0; i < lines.size(); i++) {
					writer.println(lines.get(i));
			}
			
			writer.close();
			
		} catch (FileNotFoundException fnf) {
			System.out.println("The file wasn't found");
		}
		
		this.routeNumber++;
	}
	
	public int getRouteNumber() {
		return this.routeNumber;
	}
}
