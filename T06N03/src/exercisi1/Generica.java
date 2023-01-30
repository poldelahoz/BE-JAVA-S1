package exercisi1;

public class Generica {
	
	public static <T extends Telefon> void Metode1(T t){
		t.trucar();
		// No pot cridar al mètode ferFotos() de la classe Smartphone 
		// t.ferFotos();
	}
	
	public static <T extends Smartphone> void Metode2(T t){
		t.trucar();
		t.ferFotos();
	}

}
