package exercisi1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
	
	private static final String rootPath = System.getProperty("user.dir") + "\\";
	private static final String appConfigPath = rootPath + "app.properties";
	
	public static String savePath;
	
	public static void main(String[] args){
		try {
			Properties appProps = new Properties();
			appProps.load(new FileInputStream(appConfigPath));
			String dir = appProps.getProperty("directory");
			savePath = appProps.getProperty("savePath") + ".txt";
			File file = new File(savePath);
			if(!file.createNewFile()) {
				file.delete();
				file.createNewFile();
			}
			DirectoryUtils.saveAllSubdirectoriesAndFiles(dir);
			System.out.println("Arbre complet del directori " + dir + " guardat a " + savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
