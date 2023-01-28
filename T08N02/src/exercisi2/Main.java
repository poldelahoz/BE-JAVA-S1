package exercisi2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> list = Arrays.stream(array).collect(Collectors.toList());	
		System.out.println(convertList(list));
	}
	
	private static String convertList(List<Integer> list){
		return list.stream()
					.map(i -> convertInteger(i))
			        .collect(Collectors.joining(","));
	}
	
	private static String convertInteger(Integer i) {
		if (i%2 != 0)
			return "o" + i;
		else
			return "e" + i;
	}

}