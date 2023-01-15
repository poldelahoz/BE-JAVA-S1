package exercisi2;

public class Cotxe {
	
	private static final String marca = "BMW"; // Obligats a inicialitzar-lo aquí perquè és static i final
	private static String model; // Inicialitzat amb el constructor o amb el setter
	private final String potencia; // Podem inicialitzar-lo al constructor perquè no és static
	
	public Cotxe(String model, String potencia) {
		Cotxe.model = model;
		this.potencia = potencia;
	}
	
	public static String getMarca() {
		return marca;
	}

	public void setModel(String model) {
		Cotxe.model = model;
	}
	
	public static String getModel() {
		return model;
	}
	
	public String getPotencia() {
		return potencia;
	}

	public static void frenar() {
		System.out.println("El vehicle està frenant");
	}
	
	public void accelerar() {
		System.out.println("El vehicle està accelerant");
	}
}
