package exercisi1;

public class GenericMethods {
	public <T> GenericMethods(T t1, String t2, T t3) {
		System.out.println("Paràmetre 1: " + t1
		+ "\nParàmetre 2: " + t2
		+ "\nParàmetre 3: " + t3);
	}
}
