package exercisi2;

public class Main {
	
	private static Cotxe cotxe;
	
	public static void main(String[] args) {
		cotxe = new Cotxe("Serie 2 220iA"); // La marca està ja inicialitzada anteriorment ja que és static i final. La potència s'inicialitza a dins del constructor quan es crea la instància.
		//cotxe.setModel("Serie 2 220iA");
		System.out.println(Cotxe.getMarca()); // Hem d'accedir-hi de forma estàtica fent servir el nom de la classe de base
		System.out.println(Cotxe.getModel()); // Hem d'accedir-hi de forma estàtica fent servir el nom de la classe de base
		System.out.println(cotxe.getPotencia()); // Podem accedir-hi directament fent servir la instancia creada anteriorment
		cotxe.accelerar(); // Podem accedir-hi directament fent servir la instancia creada anteriorment
		Cotxe.frenar(); // Hem d'accedir-hi de forma estàtica fent servir el nom de la classe de base
	}
}
