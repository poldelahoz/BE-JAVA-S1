package exercisi1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String[] array = {"Anna", "Pol", "Andrea", "Martí"};
		List<String> list = Arrays.stream(array).collect(Collectors.toList());
		contenenA(list).forEach(System.out::println);		
	}
	
	private static List<String> contenenA(List<String> list){
		return list.stream()
					.filter(i -> i.startsWith("A"))
					.collect(Collectors.toList());
	}
}
