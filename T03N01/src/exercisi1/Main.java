package exercisi1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	
	private static ArrayList<Month> monthList;

	public static void main(String[] args) {
		// Omplim la llista
		fillMonthList();
		// Afegim Agost a la seva posició y ho comprobem mostrant el ArrayList per pantalla recorrent amb un for 
		monthList.add(7, new Month("Agost"));
		System.out.println("Llistat de mesos després d'afegir Agost: ");
		for(Month month:monthList) {
			System.out.println(month.getName());
		}
		System.out.println("--------------------------------");
		
		//Convertim el ArrayList a HashSet i el mostrem per pantalla amb un forEach
		HashSet<Month> hashSet = new HashSet<>();
		hashSet.addAll(monthList);
		System.out.println("Llistat de mesos en un HashSet: ");
		hashSet.forEach(month -> System.out.println(month.getName()));
		System.out.println("--------------------------------");
		
		// Comprobem que no permet afegir duplicats i el mostrem per pantalla recorrent-lo amb un iterador
		hashSet.add(new Month("Febrer"));
		Iterator<Month> iterator = hashSet.iterator();
		System.out.println("Llistat de mesos en un HashSet comprobant que no accepta duplicats: ");
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}
	
	private static void fillMonthList() {
		monthList = new ArrayList<>(11);
		monthList.add(new Month("Gener"));
		monthList.add(new Month("Febrer"));
		monthList.add(new Month("Març"));
		monthList.add(new Month("Abril"));
		monthList.add(new Month("Maig"));
		monthList.add(new Month("Juny"));
		monthList.add(new Month("Juliol"));
		monthList.add(new Month("Setembre"));
		monthList.add(new Month("Octubre"));
		monthList.add(new Month("Novembre"));
		monthList.add(new Month("Desembre"));
	}
}
