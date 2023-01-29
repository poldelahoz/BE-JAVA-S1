package exercisi1;

import java.io.IOException;
import java.util.Comparator;

public class MenuOptions {
	
	public static void option1() {
		try {
			Persona persona = new Persona();
			persona.askForInformation();
			String[] data = persona.getFieldsArray();
			CsvFileUtils.writeLine(Main.filePath, data);
			Main.updatePersones();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void option2() {
		System.out.println("___Nom___ _____Cognoms_____ ___NIF___");
		Main.persones.stream()
			.sorted(Comparator.comparing(Persona::getNom))
			.forEach(c -> c.print());
	}
	
	public static void option3() {
		System.out.println("___Nom___ _____Cognoms_____ ___NIF___");
		Main.persones.stream()
			.sorted(Comparator.comparing(Persona::getNom).reversed())
			.forEach(c -> c.print());
	}
	
	public static void option4() {
		System.out.println("___Nom___ _____Cognoms_____ ___NIF___");
		Main.persones.stream()
			.sorted(Comparator.comparing(Persona::getCognom))
			.forEach(c -> c.print());
	}
	
	public static void option5() {
		System.out.println("___Nom___ _____Cognoms_____ ___NIF___");
		Main.persones.stream()
			.sorted(Comparator.comparing(Persona::getCognom).reversed())
			.forEach(c -> c.print());
	}
	
	public static void option6() {
		System.out.println("___Nom___ _____Cognoms_____ ___NIF___");
		Main.persones.stream()
			.sorted(Comparator.comparing(Persona::getDNI))
			.forEach(c -> c.print());
	}
	
	public static void option7() {
		System.out.println("___Nom___ _____Cognoms_____ ___NIF___");
		Main.persones.stream()
			.sorted(Comparator.comparing(Persona::getDNI).reversed())
			.forEach(c -> c.print());
	}
}
