package sourceCode;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class RoutesManangement {
	private static void openFile(String url) {
		File htmlFile = new File(url);
		
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static boolean deleteFile(String url) {
		File htmlFile = new File(url);
		return htmlFile.delete();
	}
	
	public static void showRoute(int routeNumber) {
		String fileName = "route" + routeNumber + ".html";
		String path = "C:\\Users\\Jhoylan Gonçalves\\Desktop\\arquivos_java\\fastparking\\" 
				+ fileName;
		RoutesManangement.openFile(path);
	}
	
	public static void deleteRoute(int routeNumber) {
		String fileName = "route" + routeNumber + ".html";
		String path = "C:\\Users\\Jhoylan Gonçalves\\Desktop\\arquivos_java\\fastparking\\" 
				+ fileName;
		RoutesManangement.deleteFile(path);
	}
}
