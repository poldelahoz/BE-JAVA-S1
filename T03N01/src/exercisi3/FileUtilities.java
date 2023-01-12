package exercisi3;

import java.io.*;
import java.util.Scanner;

public class FileUtilities {
	
	private final static String countriesFilePath = "src/exercisi3/resources/Countries.txt";
	private final static String scoresFilePath = "src/exercisi3/resources/Scores.txt";
	
	public static void readCountriesFile(){
		try {
			File countriesFile = new File(countriesFilePath);
			Scanner fileReader = new Scanner(countriesFile);
			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				String country = data.split(" ")[0].replace("_", " ");
				String capital = data.split(" ")[1].replace("_", " ");
				Main.countries.put(capital, country);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existeix el fitxer " + countriesFilePath);
		}
	}
	
	public static void saveScore(String username, Integer score){
		try {
			File scoresFile = new File(scoresFilePath);
			scoresFile.createNewFile();
			FileWriter fileWriter = new FileWriter(scoresFilePath, true);
			fileWriter.write(username + ";" + score + System.lineSeparator());
			fileWriter.flush();
			fileWriter.close();
		}catch(IOException e) {
			System.out.println("An error occurred.\n" + e.getMessage());
		}
	}
	
}
