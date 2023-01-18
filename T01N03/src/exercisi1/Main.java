package exercisi1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	
	public static Redaccio redaccio;
	private static final String[] options = {
			"1.- Introduir redactor",
            "2.- Eliminar redactor",
            "3.- Introduir notícia a un redactor.",
            "4.- Eliminar notícia",
            "5.- Mostrar totes les notícies per redactor",
            "6.- Calcular puntuació de la notícia",
            "7.- Calcular preu-notícia",
            "8.- Sortir",
	};
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		redaccio = new Redaccio(1500);
		Menu menu = new Menu(options);
		int option;
        boolean exit = false;
		while (!exit){
			menu.printMenu();
            try {
            	option = Integer.parseInt(scanner.nextLine());
                switch (option){
                    case 1: MainMenuOptions.option1(); break;
                    case 2: MainMenuOptions.option2(); break;
                    case 3: MainMenuOptions.option3(); break;
                    case 4: MainMenuOptions.option4(); break;
                    case 5: MainMenuOptions.option5(); break;
                    case 6: MainMenuOptions.option6(); break;
                    case 7: MainMenuOptions.option7(); break;
                    case 8: System.out.println("Fins aviat!"); exit = true; break;
                    default: System.out.println("Només números entre 1 i " + menu.getOptionsLength());
                }
            }
            catch (NoSuchElementException ex){
                System.out.println("Has d'introduir un número");
                scanner.next();
            }
        }
	}
}
