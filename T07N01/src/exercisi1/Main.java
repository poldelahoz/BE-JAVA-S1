package exercisi1;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		// Treballador 1
		Treballador treballador1 = new Treballador("Marc", "Martínez", 59.90);
		TreballadorOnline tOnline = new TreballadorOnline("Marc", "Martínez", 59.90, 99);
		
		// Treballador 2
		Treballador treballador2 = new Treballador("Victor", "Fernández", 49.90);
		TreballadorPresencial tPresencial = new TreballadorPresencial("Victor", "Fernández", 49.90, 149);
		
		Locale locale = Locale.getDefault();
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String souTreballador1 = numberFormat.format(treballador1.calcularSou(160));
		String souTOnline = numberFormat.format(tOnline.calcularSou(160));
		String souTreballador2 = numberFormat.format(treballador2.calcularSou(120));
	    String souTPresencial = numberFormat.format(tPresencial.calcularSou(120));
	    
	    // Mostrem el sou calculat del treballador 1 i el del treballador online per demostrar que son diferents.
	    System.out.println("Sou del treballador: " + souTreballador1);
		System.out.println("Sou del treballador online: " + souTOnline);
		// Mostrem el sou calculat del treballador 1 i el del treballador online per demostrar que son diferents.
		System.out.println("Sou del treballador: " + souTreballador2);
		System.out.println("Sou del treballador presencial: " + souTPresencial);
	}

}
