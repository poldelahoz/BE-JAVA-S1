package exercisi1;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MainMenuOptions {
	
	private static final String[] options = {
			"1.- Notícia de Futbol",
            "2.- Notícia de Basquet",
            "3.- Notícia de Tenis",
            "4.- Notícia de Formula 1",
            "5.- Notícia de Motociclisme",
            "6.- Sortir",
	};	
	
	public static void option1() {
		System.out.print("Nom del redactor: ");
		String nom = Main.scanner.nextLine();
		System.out.print("DNI del redactor: ");
		String DNI = Main.scanner.nextLine();
		Redactor redactor = new Redactor(nom, DNI);
		System.out.println();
		if(Main.redaccio.afegirRedactor(redactor))
			System.out.println("Redactor " + nom + " amb DNI " + DNI + " afegit.");
	}
	
	public static void option2() {
		System.out.print("DNI del redactor: ");
		String dni = Main.scanner.nextLine();
		Redactor redactor = Main.redaccio.getRedactor(dni);
		System.out.println();
		if (redactor != null) {
			Main.redaccio.borrarRedactor(redactor);
			System.out.println("Redactor " + redactor.getNom() + " amb DNI " + redactor.getDNI() + " eliminat.");
		}else {
			System.err.println("El redactor amb DNI " + dni + " no existeix en aquesta redacció.");
		}
	}
	
	public static void option3() {
		System.out.print("DNI del redactor: ");
		String dni = Main.scanner.nextLine();
		Redactor redactor = Main.redaccio.getRedactor(dni);
		System.out.println();
		if (redactor != null) {
			Menu menu = new Menu(options, Menu.MenuType.TIPUS_DE_NOTICIA);
			int option;
	        boolean exit = false;
			while (!exit){
				menu.printMenu();
	            try {
	            	option = Integer.parseInt(Main.scanner.nextLine());
	                switch (option){
	                    case 1: 
	                    	NoticiaFutbol nFutbol = new NoticiaFutbol();
	                    	nFutbol.demanarInformacio();
	                    	redactor.afegirNoticia(nFutbol);
	                    	exit = true; 
	                    	break;
	                    case 2:
	                    	NoticiaBasquet nBasquet = new NoticiaBasquet();
	                    	nBasquet.demanarInformacio();
	                    	redactor.afegirNoticia(nBasquet);
	                    	exit = true; 
	                    	break;
	                    case 3:
	                    	NoticiaTenis nTenis = new NoticiaTenis();
	                    	nTenis.demanarInformacio();
	                    	redactor.afegirNoticia(nTenis);
	                    	exit = true; 
	                    	break;
	                    case 4: 
	                    	NoticiaF1 nF1 = new NoticiaF1();
	                    	nF1.demanarInformacio();
	                    	redactor.afegirNoticia(nF1);
	                    	exit = true; 
	                    	break;
	                    case 5: 
	                    	NoticiaMotociclisme nMotociclisme = new NoticiaMotociclisme();
	                    	nMotociclisme.demanarInformacio();
	                    	redactor.afegirNoticia(nMotociclisme);
	                    	exit = true; 
	                    	break;
	                    case 6: exit = true; break;
	                    default: System.err.println("Només números entre 1 i " + menu.getOptionsLength());
	                }
	            }
	            catch (NoSuchElementException ex){
	                System.err.println("Has d'introduir un número");
	                Main.scanner.next();
	            }
	        }
		}else {
			System.err.println("El redactor amb DNI/Nom " + dni + " no existeix en aquesta redacció.");
		}
	}
	
	public static void option4() {
		System.out.print("DNI del redactor: ");
		String dni = Main.scanner.nextLine();
		Redactor redactor = Main.redaccio.getRedactor(dni);
		if (redactor != null) {
			System.out.print("Titular de la notícia: ");
			String titular = Main.scanner.nextLine();
			System.out.println();
			if (redactor.borrarNoticia(titular)) {
				System.out.println("Notícia '" + titular + "' eliminada.");
			}else {
				System.err.println("La notícia '" + titular + "' no existeix pel redactor " + redactor.getNom() + " amb DNI " + redactor.getDNI());
			}
		}else {
			System.err.println("El redactor amb DNI " + dni + " no existeix en aquesta redacció.");
		}
	}
	
	public static void option5() {
		List<Redactor> redactors = Main.redaccio.getRedactors();
		Redactor redactor;
		ListIterator<Redactor> iterator = redactors.listIterator();
		while(iterator.hasNext()) {
			redactor = iterator.next();
			System.out.println("--------------------------- REDACTOR ---------------------------");
			System.out.println("Nom: " + redactor.getNom());
			System.out.println("DNI: " + redactor.getDNI());
			System.out.println("NOTICIES:");
			redactor.getNoticies().forEach(noticia -> {
					noticia.mostrarInformacio();
					System.out.println();
				}
			);
			System.out.println();
		}
	}
	
	public static void option6() {
		System.out.print("DNI del redactor: ");
		String dni = Main.scanner.nextLine();
		Redactor redactor = Main.redaccio.getRedactor(dni);
		if (redactor != null) {
			System.out.print("Titular de la notícia: ");
			String titular = Main.scanner.nextLine();
			System.out.println();
			Noticia noticia = redactor.getNoticia(titular);
			if (noticia != null) {
				System.out.println("Puntuació de la notícia: " + noticia.getPuntuacio() + " punts");
			}else {
				System.err.println("El redactor amb DNI " + dni + " no té aquesta notícia.");
			}
		}else {
			System.err.println("El redactor amb DNI " + dni + " no existeix en aquesta redacció.");
		}
	}
	
	public static void option7() {
		System.out.print("DNI del redactor: ");
		String dni = Main.scanner.nextLine();
		Redactor redactor = Main.redaccio.getRedactor(dni);
		if (redactor != null) {
			System.out.print("Titular de la notícia: ");
			String titular = Main.scanner.nextLine();
			System.out.println();
			Noticia noticia = redactor.getNoticia(titular);
			if (noticia != null) {
				System.out.printf("Preu de la notícia: %,.2f €", noticia.getPreu());
				System.out.println();
			}else {
				System.err.println("El redactor amb DNI " + dni + " no té aquesta notícia.");
			}
		}else {
			System.err.println("El redactor amb DNI " + dni + " no existeix en aquesta redacció.");
		}
	}
}
