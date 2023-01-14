package exercisis;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	
	public static final String savePath = System.getProperty("user.dir") + "\\results\\";
	private static final String[] options = {"1- Exercisi 1: Llistar alfabéticament el contingut d'un directori",
            "2- Exercisi 2: Mostrar l'arbre complet d'un directori.",
            "3- Exercisi 3: Guardar l'arbre complet d'un directori a un fitxer TXT",
            "4- Exercisi 4: Llegir un fitxer TXT i mostrar el seu contingut",
            "5- Exercisi 5: ",
            "6- Sortir",
	};
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println(savePath);
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
                    case 6: exit = true; break;
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
		System.out.println("--------------------------- MENÚ ---------------------------");
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
		System.out.println("Contingut ordenat alfabéticament del directori " + dir + ":");
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
		String dir;
	}
}
