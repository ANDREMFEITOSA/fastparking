package fastparking;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class GarageSearch {
	//Method1: java.net.HttpURLConnection
	private static HttpURLConnection connection;
	private String key = "AIzaSyDqGIMchOeXPAlfe1qzQjAlUt5QVf6lh8s";
	private BufferedReader reader;
	private String line;
	private StringBuffer responseContent = new StringBuffer();
	private List<String> distances = new ArrayList<>();
	private int lines = 0;
	
	public void request(String origin, String destination) {
		try {
			URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?"
					+ "units=si&origins=" + origin + "&destinations=" + destination + "&key=" + key);
			connection = (HttpURLConnection) url.openConnection();
			
			//Request method
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			
			if(status < 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				while((line = reader.readLine()) != null) {
					if (line.contains("km")) {
						distances.add(line);
					}
				}
				
				reader.close();
				
			}else {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				
				reader.close();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		
	}	

	public List<Float> distancesValues() {
		List<Float> floatDistances = new ArrayList<>();
		
		for(int i =0; i < this.distances.size(); i++) {
			String distanceString = distances.get(i).substring(28, distances.get(i).length() - 5);
			distances.set(i, distanceString);
			float distance = Float.parseFloat(distanceString);
			floatDistances.add(distance);
		}
		
		return floatDistances;
	}

	public int getTheClosestGaragePosition(List<Float> garagesDistances) {
		int closestGaragePosition = 0;
		float min = garagesDistances.get(0);
		
		for(int i = 1; i < garagesDistances.size(); i++) {
			if(garagesDistances.get(i) < min) {
				min = garagesDistances.get(i);
				closestGaragePosition = i;
			}
		}
		
		return closestGaragePosition;
	}

	public String formattingDestinationString(List<Garage> garages) {
		String destination = "";
		
		for(int i = 0; i < garages.size(); i++) {
			destination += garages.get(i).getLocation();
			
			if(i < garages.size() - 1) {
				destination += "|";
			}
		}
		
		return destination;
	}

	public Garage closestGarage(List<Garage> garages, Driver driver) {
		String origin = driver.getLocation();
		String destination = this.formattingDestinationString(garages);
		
		this.request(origin, destination);
		
		int position = this.getTheClosestGaragePosition(this.distancesValues());
		
		return garages.get(position);
	}

	public void openFile(String url) {
		File htmlFile = new File(url);
		
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showRoute(int routeNumber) {
		String fileName = "route" + routeNumber + ".html";
		String path = "C:\\Users\\Jhoylan Gonçalves\\Desktop\\arquivos_java\\fastparking\\" 
				+ fileName;
		this.openFile(path);
	}
}
