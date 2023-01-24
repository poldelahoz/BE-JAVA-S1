package exercisi2;


public class GenericMethods {
	
	@SuppressWarnings("unchecked")
	public <T> GenericMethods(T... objects) {
		for(T o : objects) {
			System.out.println(o);
		}
	}
	
}
