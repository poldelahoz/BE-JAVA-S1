package exercisi6;

public class ProvocaExcepcio {
	
	public static void printArrayList() {
		try {
			String[] array = {"1","2","3","4"};   
			System.out.println(array[4]);
		}catch(ArrayIndexOutOfBoundsException e) {
			throw e;
		}
	}
}
