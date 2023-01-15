package exercisi3;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static HashMap<String,String> countries = new HashMap<String,String>();

	public static void main(String[] args) {
		
		// Demanem el nom d'usuari/aria
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueix el teu nom d'usuari/ària:");
		String username = scanner.nextLine();
		
		FileUtilities.readCountriesFile();
		
		Integer score = 0;
		Random generator = new Random();
		String askedCountries = "";
		for(int i = 0; i < 10; i++) {
			Object[] countriesArray = countries.values().toArray();
			int randomNumber;
			
			// Comprobem que no surti un país repetit per casualitat
			do {
				randomNumber = generator.nextInt(countriesArray.length);
			}while(askedCountries.contains(Integer.toString(randomNumber)));
			askedCountries += randomNumber + ";";
			
			// Obtenim el país aleatori, preguntem per la capital y comprobem si es correcte
			String randomCountry = (String) countriesArray[randomNumber];
			System.out.println("Capital de " + randomCountry + ":");
			String capital = scanner.nextLine();
			if (randomCountry.equals(countries.get(capital))) score++;
		}
		scanner.close();
		
		// Escribim resultat al fitxer i el mostrem per pantalla
		FileUtilities.saveScore(username, score);
		System.out.println("La teva puntuació: " + score + "/10");
		System.out.println("Gràcies per jugar!");
	}

}
