package exercisi2;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		TreballadorOnline tOnline = new TreballadorOnline("Marc", "Martínez", 59.90, 99);
		TreballadorPresencial tPresencial = new TreballadorPresencial("Victor", "Fernández", 49.90, 149);
	    
	    // Cridem al mètodo obsolet de la classe TreballadorOnline
	    tOnline.deprecatedMethod();
	    
	    // Cridem al mètodo obsolet de la classe TreballadorOnline
	    tPresencial.deprecatedMethod();
	}

}
