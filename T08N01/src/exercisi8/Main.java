package exercisi8;

public class Main {

	public static void main(String[] args) {
		ListUtils listUtils = str -> {
			String result = "";
	         for(int i = str.length()-1; i >= 0; i--)
	            result += str.charAt(i);
	         return result;
		};
		
		String str = "ITAcademy";
		System.out.println("Cadena original: " + str);
		System.out.println("Cadena del revés: " + listUtils.reverse(str));
	}
}
