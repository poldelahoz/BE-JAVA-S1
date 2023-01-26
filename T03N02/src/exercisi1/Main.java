package exercisi1;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		HashSet<Restaurant> hashSet = new HashSet<Restaurant>();
		Restaurant r1 = new Restaurant("Restaurant1", 8);
		Restaurant r2 = new Restaurant("Restaurant2", 7);
		Restaurant r3 = new Restaurant("Restaurant2", 6);
		Restaurant r4 = new Restaurant("Restaurant4", 5);
		hashSet.add(r1);
		hashSet.add(r2);
		hashSet.add(r3);
		hashSet.add(r4);
		System.out.println("Mostrem per consola el contingut del HashSet demostrant que el Restaurant r2 no l'ha afegit ja que és igual que el Restaurant r1.");
		hashSet.forEach(r -> System.out.println("nom: " + r.getNom() + ", puntuació: " + r.getPuntuacio()));
	}

}
