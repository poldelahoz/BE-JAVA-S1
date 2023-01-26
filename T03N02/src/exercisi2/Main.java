package exercisi2;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import exercisi1.Restaurant;

public class Main {

	public static void main(String[] args) {
		SortedSet<Restaurant> sortedSet = new TreeSet<Restaurant>(new RestaurantComparator());
		Restaurant r1 = new Restaurant("Restaurant1", 8);
		Restaurant r2 = new Restaurant("Restaurant2", 7);
		Restaurant r3 = new Restaurant("Restaurant2", 6);
		Restaurant r4 = new Restaurant("Restaurant4", 5);
		sortedSet.add(r1);
		sortedSet.add(r2);
		sortedSet.add(r3);
		sortedSet.add(r4);
		System.out.println("Mostrem per consola el contingut del SortedSet demostrant que està ordenat per nom i per puntuació ascendent.");
		sortedSet.forEach(r -> System.out.println("nom: " + r.getNom() + ", puntuació: " + r.getPuntuacio()));
	}
	
	public static class RestaurantComparator implements Comparator<Restaurant> {
	    @Override public int compare(Restaurant r1, Restaurant r2)
	    {
	    	int nameDiff = r1.getNom().compareToIgnoreCase(r2.getNom());
			if(nameDiff != 0){
	            return nameDiff;
	        }
			return r1.getPuntuacio() - r2.getPuntuacio();
	    }
	}
}
