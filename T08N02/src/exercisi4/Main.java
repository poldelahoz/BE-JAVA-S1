package exercisi4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String[] array = {"anna", "1", "pol", "andrea", "2", "Eduard", "3", "4", "5"};
		List<String> list = Arrays.stream(array).collect(Collectors.toList());
		System.out.println("Ordena alfabèticament pel primer caràcter.");
		char c;
		list.stream().sorted(Comparator.comparing(i -> i.charAt(0))).forEach(System.out::println);
		System.out.println();
		System.out.println("Les cadenes que contenen una \"e\" primer, la resta de cadenes després.");
		list.stream().sorted(Comparator.comparing(i ->  i.substring(0,1))).forEach(System.out::println);
		System.out.println("Modifica tots els elements de la llista que tenen una ‘a’. Modifica la ‘a’ per un ‘4’.");
		list.stream().map(i -> i.replace("a","4")).forEach(System.out::println);
		System.out.println();
		System.out.println("Mostra només els elements que són numèrics.");
		list.stream().filter(i -> i.matches("[0-9]+")).forEach(System.out::println);
	}

}
