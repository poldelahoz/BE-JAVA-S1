package exercisi1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.NoSuchElementException;

public class MainMenuOptions {
	
	private static final String[] options = {
			"1.- Futbol",
            "2.- Basquet",
            "3.- Tenis",
            "4.- Formula 1",
            "5.- Motociclisme",
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
		System.out.print("DNI o nom del redactor: ");
		String DniNom = Main.scanner.nextLine();
		Redactor redactor = Main.redaccio.getRedactor(DniNom);
		if (redactor == null) {
			System.out.println("El redactor amb DNI/Nom \" + DniNom + \" no existeix en aquesta redacció.");
		}else {
			System.out.println();
			Main.redaccio.borrarRedactor(redactor);
			System.out.println("Redactor " + redactor.getNom() + " amb DNI " + redactor.getDNI() + " eliminat.");
		}
	}
	
	public static void option3() {
		System.out.print("DNI o nom del redactor: ");
		String DniNom = Main.scanner.nextLine();
		Redactor redactor = Main.redaccio.getRedactor(DniNom);
		if (redactor == null) {
			System.out.println("El redactor amb DNI/Nom \" + DniNom + \" no existeix en aquesta redacció.");
		}else {
			System.out.print("Informació de la notícia");
			System.out.print("Titular: ");
			Noticia noticia = new Noticia(Main.scanner.nextLine());
			redactor.afegirNoticia(noticia);
		}
	}
	
	public static void option4() {
		System.out.print("Nom del redactor: ");
		String nom = Main.scanner.nextLine();
		System.out.print("Titutal de la notícia: ");
		String titular = Main.scanner.nextLine();
		Redactor redactor = Main.redaccio.getRedactor(nom);
		
		if (redactor == null) {
			System.out.println("El redactor amb nom " + nom + " no existeix en aquesta redacció.");
		}else {
			Noticia noticia = redactor.getNoticia(titular);
			if (noticia == null) {
				System.out.println("La notícia '" + titular + "' no existeix pel redactor " + nom);
			}else {
				System.out.println();
				redactor.borrarNoticia(noticia);
				System.out.println("Notícia '" + noticia.getTitular() + "' eliminada.");
			}
		}
	}
	
	public static void option5() {
		
	}
	
	public static void option6() {
		Menu menu = new Menu(options);
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
                    	nFutbol.calcularPuntuacio();
                		System.out.println("La puntuació d'aquesta notícia es de " + nFutbol.getPuntuacio() + " punts.");
                    	exit = true; 
                    	break;
                    case 2:
                    	NoticiaBasquet nBasquet = new NoticiaBasquet();
                    	nBasquet.demanarInformacio();
                    	nBasquet.calcularPuntuacio();
                		System.out.println("La puntuació d'aquesta notícia es de " + nBasquet.getPuntuacio() + " punts.");
                    	exit = true; 
                    	break;
                    case 3:
                    	NoticiaTenis nTenis = new NoticiaTenis();
                    	nTenis.demanarInformacio();
                    	nTenis.calcularPuntuacio();
                		System.out.println("La puntuació d'aquesta notícia es de " + nTenis.getPuntuacio() + " punts.");
                    	exit = true; 
                    	break;
                    case 4: 
                    	NoticiaF1 nF1 = new NoticiaF1();
                    	nF1.demanarInformacio();
                    	nF1.calcularPuntuacio();
                		System.out.println("La puntuació d'aquesta notícia es de " + nF1.getPuntuacio() + " punts.");
                    	exit = true; 
                    	break;
                    case 5: 
                    	NoticiaMotociclisme nMotociclisme = new NoticiaMotociclisme();
                    	nMotociclisme.demanarInformacio();
                    	nMotociclisme.calcularPuntuacio();
                		System.out.println("La puntuació d'aquesta notícia es de " + nMotociclisme.getPuntuacio() + " punts.");
                    	exit = true; 
                    	break;
                    case 6: exit = true; break;
                    default: System.out.println("Només números entre 1 i " + menu.getOptionsLength());
                }
            }
            catch (NoSuchElementException ex){
                System.out.println("Has d'introduir un número");
                Main.scanner.next();
            }
        }
	}
	
	public static void option7() {
		Locale locale = Locale.getDefault();
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		Menu menu = new Menu(options);
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
                    	nFutbol.calcularPreuNoticia();
                		System.out.println("El preu d'aquesta notícia es de " + numberFormat.format(nFutbol.getPuntuacio()));
                    	exit = true; 
                    	break;
                    case 2:
                    	NoticiaBasquet nBasquet = new NoticiaBasquet();
                    	nBasquet.demanarInformacio();
                    	nBasquet.calcularPreuNoticia();
                    	System.out.println("El preu d'aquesta notícia es de " + numberFormat.format(nBasquet.getPuntuacio()));
                    	exit = true; 
                    	break;
                    case 3:
                    	NoticiaTenis nTenis = new NoticiaTenis();
                    	nTenis.demanarInformacio();
                    	nTenis.calcularPreuNoticia();
                    	System.out.println("El preu d'aquesta notícia es de " + numberFormat.format(nTenis.getPuntuacio()));
                    	exit = true; 
                    	break;
                    case 4: 
                    	NoticiaF1 nF1 = new NoticiaF1();
                    	nF1.demanarInformacio();
                    	nF1.calcularPreuNoticia();
                    	System.out.println("El preu d'aquesta notícia es de " + numberFormat.format(nF1.getPuntuacio()));
                    	exit = true; 
                    	break;
                    case 5: 
                    	NoticiaMotociclisme nMotociclisme = new NoticiaMotociclisme();
                    	nMotociclisme.demanarInformacio();
                    	nMotociclisme.calcularPreuNoticia();
                    	System.out.println("El preu d'aquesta notícia es de " + numberFormat.format(nMotociclisme.getPuntuacio()));
                    	exit = true; 
                    	break;
                    case 6: exit = true; break;
                    default: System.out.println("Només números entre 1 i " + menu.getOptionsLength());
                }
            }
            catch (NoSuchElementException ex){
                System.out.println("Has d'introduir un número");
                Main.scanner.next();
            }
        }
	}
}
