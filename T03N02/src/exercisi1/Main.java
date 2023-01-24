package exercisi1;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		HashSet<Restaurant> hashSet = new HashSet<Restaurant>();
		Restaurant r1 = new Restaurant("La Fontana", 10);
		Restaurant r2 = new Restaurant("La Fontana", 10);
		hashSet.add(r1);
		hashSet.add(r2);
		System.out.println("Mostrem per consola el contingut del HashSet demostrant que el Restaurant r2 no l'ha afegit ja que és igual que el Restaurant r1.");
		hashSet.forEach(System.out::println);
	}

}
