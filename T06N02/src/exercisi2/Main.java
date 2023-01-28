package exercisi2;


public class Main {

	public static <T> void main(String[] args) {
		System.out.println("Li passem 3 paràmetres: ");
		new GenericMethods(new Persona("Pol", "de la Hoz", 29), "Això es un String", Integer.valueOf(1));
		System.out.println();
		System.out.println("Li passem 2 paràmetres: ");
		new GenericMethods(new Persona("Pol", "de la Hoz", 29), "Això es un String");
	}

}
