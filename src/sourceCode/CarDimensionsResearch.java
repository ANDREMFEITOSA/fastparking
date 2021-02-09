package sourceCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CarDimensionsResearch {
	private static HttpURLConnection connection;
	private String key = "othsziul6_1v41nfav0_mevqsi7or";
	private BufferedReader reader;
	private String line;
	private String responseContent;
	int lines = 0;
		
	public void request(String vin) {
		try {
			URL url = new URL("https://api.carsxe.com/specs?key=" + key + "&vin=" + vin + "&format=json");
			connection = (HttpURLConnection) url.openConnection();
			
			//Request method
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			
			if(status < 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				while((line = reader.readLine()) != null) {
					this.responseContent = line;				
				}
				
				reader.close();
				
			}else {
				System.out.println("Url error");
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

	public BigDecimal getLength() {
		String lengthKey = "\"overall_length\":\"";
		String endPosition = " in.";	
		String lengthString = "";
		
		for(int i = 0; i < this.responseContent.length(); i++) {
			String StringSequence1 = responseContent.substring(i, i + 18);
			int beginingPoint = 0;
			int endingPoint = 0;
			
			if(StringSequence1.equals(lengthKey)) {
				beginingPoint = i + 18;
				boolean toBreak = false;
				
				for(int j = i + 1; j < this.responseContent.length(); j++) {
					String StringSequence2 = responseContent.substring(j, j + 4);
					
					if(StringSequence2.equals(endPosition)) {
						endingPoint = j;
						toBreak = true;
						break;
					}
				}
				
				lengthString = responseContent.substring(beginingPoint, endingPoint);
				
				if(toBreak) {
					break;
				}
			}
		}
		
		BigDecimal lengthInInches = new BigDecimal(lengthString);
		BigDecimal converterToMeters = new BigDecimal("39.37");
		
		return lengthInInches.divide(converterToMeters, 2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getWidth() {
		String widthKey = "\"overall_width\":\"";
		String endPosition = " in.";	
		String widthString = "";
		
		for(int i = 0; i < this.responseContent.length(); i++) {
			String StringSequence1 = responseContent.substring(i, i + 17);
			int beginingPoint = 0;
			int endingPoint = 0;
			
			if(StringSequence1.equals(widthKey)) {
				beginingPoint = i + 17;
				boolean toBreak = false;
				
				for(int j = i + 1; j < this.responseContent.length(); j++) {
					String StringSequence2 = responseContent.substring(j, j + 4);
					
					if(StringSequence2.equals(endPosition)) {
						endingPoint = j;
						toBreak = true;
						break;
					}
				}
				
				widthString = responseContent.substring(beginingPoint, endingPoint);
				
				if(toBreak) {
					break;
				}
			}
		}
		
		BigDecimal widthInInches = new BigDecimal(widthString);
		BigDecimal converterToMeters = new BigDecimal("39.37");
		
		return widthInInches.divide(converterToMeters, 2, RoundingMode.HALF_UP);
		
	}
}
