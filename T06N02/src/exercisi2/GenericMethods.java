package exercisi2;

import java.util.List;

public class GenericMethods {
	public <T> GenericMethods(List<T> list) {
		list.stream().forEach(System.out::println);
	}
}
