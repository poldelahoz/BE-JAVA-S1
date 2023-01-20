package exercisi1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<String> sList = Stream.of("Hola", "estoy", "usando", "expresiones", "lambda", "y", "stream")
								.collect(Collectors.toList());
		
		List<String> filteredList = containsO(sList);
		filteredList.forEach(s -> System.out.println(s)); 
	}
	
	private static List<String> containsO(List<String> sList){
		return sList.stream().filter(s -> s.contains("o")).collect(Collectors.toList());
	}
}
