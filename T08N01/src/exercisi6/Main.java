package exercisi6;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<String> list = Stream.of(
				"Gener", "Febrer", "Març", "Abril",
				"1", "10", "100", "1000",
				"Setembre", "Octubre", "Novembre", "Desembre")
			.collect(Collectors.toList());
		
		Comparator<String> compByLength = (string1, string2) -> string1.length() - string2.length();
		List<String> sortedList = list.stream()
				.sorted(compByLength)
				.collect(Collectors.toList());

	    sortedList.forEach(System.out::println);
	}

}
