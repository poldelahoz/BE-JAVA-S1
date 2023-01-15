package exercisi2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		List<Integer> list2 = new ArrayList<Integer>();
		System.out.println("Llista 1: " + list1);
		System.out.println("Llista 2 buida: " + list2);
		
		ListIterator<Integer> listIterator = list1.listIterator(list1.size());
		while(listIterator.hasPrevious()) {
			list2.add(listIterator.previous());
		}
		
		System.out.println("Llista 2 omplerta: " + list2);
	}

}
