package exercisis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	
	public static final String savePath = System.getProperty("user.dir") + "\\results\\";
	private static final String[] options = {"1- Exercisi 1: Llistar alfabèticament el contingut d'un directori",
            "2- Exercisi 2: Mostrar l'arbre complet d'un directori.",
            "3- Exercisi 3: Guardar l'arbre complet d'un directori a un fitxer TXT",
            "4- Exercisi 4: Llegir un fitxer TXT i mostrar el seu contingut",
            "5- Exercisi 5: Desserialitzar un objecte en un fitxer, tornar-lo a serialitzar i mostrar-lo per pantalla",
            "6- Sortir",
	};
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		Files.createDirectories(Paths.get(savePath));
		
        int option;
        boolean exit = false;
		while (!exit){
            printMenu(options);
            try {
            	option = Integer.parseInt(scanner.nextLine());
                switch (option){
                    case 1: option1(); break;
                    case 2: option2(); break;
                    case 3: option3(); break;
                    case 4: option4(); break;
                    case 5: option5(); break;
                    case 6: System.out.println("Fins aviat!"); exit = true; break;
                    default: System.out.println("Només números entre 1 i " + options.length);
                }
            }
            catch (NoSuchElementException ex){
                System.out.println("Has d'introduir un número");
                scanner.next();
            }
        }
	}
	
	private static void printMenu(String[] options) {
		System.out.println();
		System.out.println("--------------------------- MENÃš ---------------------------");
		for (String option : options){
            System.out.println(option);
        }
		System.out.println();
        System.out.print("Tria una opció: ");
	}
	
	private static void option1() {
		System.out.print("Introdueix un directori complet: ");
		String dir = scanner.nextLine();
		System.out.println();
		System.out.println("Contingut ordenat alfabèticament del directori " + dir + ":");
		DirectoryUtils.printContentOrdered(dir);
	}
	
	private static void option2() {
		System.out.print("Introdueix un directori complet: ");
		String dir = scanner.nextLine();
		System.out.println();
		System.out.println("Arbre complet del directori " + dir + ":");
		DirectoryUtils.printAllSubdirectoriesAndFiles(dir);
	}
	
	private static void option3() {
		System.out.print("Introdueix un directori complet: ");
		String dir = scanner.nextLine();
		System.out.println();
		DirectoryUtils.saveAllSubdirectoriesAndFiles(dir);
		System.out.println("Arbre complet del directori guardat a " + savePath);
	}
	
	private static void option4() {
		System.out.print("Introdueix el directori d'un fitxer TXT: ");
		String dir = scanner.nextLine();
		System.out.println();
		DirectoryUtils.printFile(dir);
	}
	
	private static void option5() {
		try {
			
			System.out.println("Creem una nova instància d'un objecte anomenat Persona i el mostrem per pantalla: ");
			Persona persona = new Persona("Pol de la Hoz", 29, "Masculí");
			System.out.println(persona.toString());
			
			System.out.println("Serialitzem l'objecte i l'escribim a un fitxer.");
			String myObjectFilePath = savePath + "myObject.ser";
			File myObjectFile = new File(myObjectFilePath);
			myObjectFile.createNewFile();
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(myObjectFile);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(persona);
			objectOutputStream.close();
			fileOutputStream.close();
			
			System.out.println("Desserialitzem l'objecte guardat al fitxer i el mostrem per pantalla per demostrar que és igual: ");
			FileInputStream fileInputStream = new FileInputStream(myObjectFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			Persona persona2 = (Persona) objectInputStream.readObject();
			System.out.println(persona2.toString());
			objectInputStream.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fitxer no trobat: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error initializing stream: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("La classe del objecte que s'ha intentat deserialitzar no existeix: " + e.getMessage());
		}
	}
}
