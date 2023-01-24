package exercisi1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Alumne[] alumnesArray = {
				new Alumne("Albert", 16, "PHP", 3),
				new Alumne("Andrea", 17, "JAVA", 4),
				new Alumne("Joan", 18, "REACT", 5),
				new Alumne("Maria", 19, "PHP", 6),
				new Alumne("Pol", 18, "JAVA", 7),
				new Alumne("Carla", 17, "REACT", 6),
				new Alumne("Marc", 16, "PHP", 5),
				new Alumne("Silvia", 17, "JAVA", 4),
				new Alumne("Alex", 18, "REACT", 3),
				new Alumne("Anna", 19, "PHP", 8)
		};
		List<Alumne> alumnes = Arrays.stream(alumnesArray).collect(Collectors.toList());
		
		
		System.out.println("Mostra per pantalla el nom i l’edat de cada alumne/a.");
		alumnes.forEach(a -> System.out.println("Nom: " + a.getNom() + " | Edat: " + a.getEdat()));
		System.out.println();
		
		System.out.println("Filtra la llista per tots els alumnes que el seu nom comença per ‘a’. Assigna a aquests alumnes a una altra  llista i  mostra per pantalla la nova llista (tot  amb lambdes).");
		List<Alumne> alumnesAmbA = alumnes.stream()
				.filter(a -> a.getNom().substring(0,1).equalsIgnoreCase("a"))
				.collect(Collectors.toList());
		alumnesAmbA.forEach(a -> System.out.println("Nom: " + a.getNom() + " | Edat: " + a.getEdat() + " | Curs: " + a.getCurs() + " | Nota: " + a.getNota()));
		System.out.println();
		
		System.out.println("Filtra i mostra per pantalla els alumnes que tenen una nota de 5 o superior.");
		alumnes.stream()
				.filter(a -> a.getNota() >= 5)
				.forEach(a -> System.out.println("Nom: " + a.getNom() + " | Edat: " + a.getEdat() + " | Curs: " + a.getCurs() + " | Nota: " + a.getNota()));
		System.out.println();
		
		System.out.println("Filtra i mostra per pantalla els alumnes que tenen un nota de 5 o més, i que no són de PHP.");
		alumnes.stream()
				.filter(a -> a.getNota() >= 5 && !a.getCurs().equals("PHP"))
				.forEach(a -> System.out.println("Nom: " + a.getNom() + " | Edat: " + a.getEdat() + " | Curs: " + a.getCurs() + " | Nota: " + a.getNota()));
		System.out.println();
		
		System.out.println("Mostra tots els alumnes que fan JAVA i són majors d’edat.");
		alumnes.stream()
				.filter(a -> a.getCurs().equals("JAVA") && a.getEdat() >= 18)
				.forEach(a -> System.out.println("Nom: " + a.getNom() + " | Edat: " + a.getEdat() + " | Curs: " + a.getCurs() + " | Nota: " + a.getNota()));
		System.out.println();
	}

}
