package exercisi1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileUtils {
	
	public static void saveToFile(String data, String savePath, String fileExtension){
		try {
			String dateTime = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
			String fullSavePath = savePath + "SerializedObject_" + dateTime + "." + fileExtension;
			File file = new File(fullSavePath);
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(fullSavePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(data);
			bufferedWriter.newLine();
			bufferedWriter.close();
		}catch(IOException e) {
			System.out.println("An error occurred.\n" + e.getMessage());
		}
	}
}
