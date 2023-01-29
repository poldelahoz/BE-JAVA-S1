package exercisi1;

public class Generica {
	
	public static <T> void Metode1(Telefon<T> telefon){
		telefon.trucar();
		// No pot cridar al mètode ferFotos() de la classe Smartphone 
		// telefon.ferFotos();
	}
	
	public static <T> void Metode2(Smartphone<? extends Telefon<T>> smartphone){
		smartphone.trucar();
		smartphone.ferFotos();
	}

}
