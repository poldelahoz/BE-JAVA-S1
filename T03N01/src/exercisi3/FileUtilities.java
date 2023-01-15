package exercisi3;

import java.io.*;
import java.util.Scanner;

public class FileUtilities {
	
	private final static String countriesFilePath = "src/exercisi3/resources/Countries.txt";
	private final static String scoresFilePath = "src/exercisi3/resources/Scores.txt";
	
	public static void readCountriesFile(){
		try {
			FileReader fileReader = new FileReader(countriesFilePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while(line!=null){
				String country = line.split(" ")[0].replace("_", " ");
				String capital = line.split(" ")[1].replace("_", " ");
				Main.countries.put(capital, country);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		}catch (IOException e) {
			System.out.println("An error occurred.\n" + e.getMessage());
		}
	}
	
	public static void saveScore(String username, Integer score){
		try {
			File scoresFile = new File(scoresFilePath);
			scoresFile.createNewFile();
			FileWriter fileWriter = new FileWriter(scoresFilePath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(username + ";" + score);
			bufferedWriter.newLine();
			bufferedWriter.close();
		}catch(IOException e) {
			System.out.println("An error occurred.\n" + e.getMessage());
		}
	}
	
}
