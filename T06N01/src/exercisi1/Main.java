package exercisi1;

public class Main {

	public static void main(String[] args) {
		System.out.println("Instanciem i inicialitzem la classe NoGenericMethods passant els valors al constructor en l'ordre correcte: ");
		NoGenericMethods noGenericMethods = new NoGenericMethods("Pol", "de la Hoz", "Male");
		System.out.println("Name: " + noGenericMethods.getName()
							+ "\nLast name: " + noGenericMethods.getLastName()
							+ "\nGender: " + noGenericMethods.getGender());
		System.out.println();
		System.out.println("Instanciem i inicialitzem la classe NoGenericMethods passant els valors al constructor en un altre ordre: ");
		noGenericMethods = new NoGenericMethods("de la Hoz", "Male", "Pol");
		System.out.println("Name: " + noGenericMethods.getName()
							+ "\nLast name: " + noGenericMethods.getLastName()
							+ "\nGender: " + noGenericMethods.getGender());
		
	}

}
