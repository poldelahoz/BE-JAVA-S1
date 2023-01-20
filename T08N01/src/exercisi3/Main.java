package exercisi3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<String> sList = Stream.of(
					"Gener", "Febrer", "Març", "Abril",
					"Maig", "Juny", "Juliol", "Agost",
					"Setembre", "Octubre", "Novembre", "Desembre")
				.collect(Collectors.toList());
		
		sList.forEach(s -> System.out.println(s));
	}

}
