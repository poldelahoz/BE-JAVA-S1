package exercisi1;

public class Generica {
	
	public static <T> void Metode1(Telefon telefon){
		telefon.trucar();
		// No pot cridar al mètode ferFotos() de la classe Smartphone 
		// telefon.ferFotos();
	}
	
	public static <T> void Metode2(Smartphone smartphone){
		smartphone.trucar();
		smartphone.ferFotos();
	}

}
