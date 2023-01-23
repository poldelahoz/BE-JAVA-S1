package exercisi2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	@SuppressWarnings("unchecked")
	public static <T> void main(String[] args) {
		List<T> list = new ArrayList<>();
		list.add((T) new Persona("Pol", "de la Hoz", 29));
		list.add((T) "Això es un String");
		list.add((T) Integer.valueOf(1));
		new GenericMethods(list);
	}

}
