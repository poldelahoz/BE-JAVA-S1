package exercisi1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static byte llegirByte(String missatge) {
		try {
			System.out.println(missatge);
			return scanner.nextByte();
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return llegirByte(missatge);
		}
	}
	
	public static int llegirInt(String missatge) {
		try {
			System.out.println(missatge);
			return scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return llegirInt(missatge);
		}
	}
	
	public static float llegirFloat(String missatge) {
		try {
			System.out.println(missatge);
			return scanner.nextFloat();
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return llegirFloat(missatge);
		}
	}
	
	public static double llegirDouble(String missatge) {
		try {
			System.out.println(missatge);
			return scanner.nextDouble();
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return llegirDouble(missatge);
		}
	}
	
	public static char llegirChar(String missatge) {
		try {
			System.out.println(missatge);
			String out = scanner.next();
			if (out.length() == 1)
				return out.charAt(0);
			else
				throw new Exception();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error de format.");
			return llegirChar(missatge);
		}
	}
	
	public static String llegirString(String missatge) {
		try {
			System.out.println(missatge);
			String out = scanner.next();
			return out;
		}catch(Exception e) {
			System.out.println("Error de format.");
			//scanner.next();
			return llegirString(missatge);
		}
	}
	
	public static boolean llegirSiNo(String missatge) {
		try {
			System.out.println(missatge);
			String out = scanner.next();
			char c;
			if (out.length() == 1)
				c = out.charAt(0);
			else
				throw new Exception();
			
			if (Character.toLowerCase(c) == 's') return true;
			if (Character.toLowerCase(c) == 'n') return false;
			
			throw new Exception();
		}catch(Exception e) {
			System.out.println("Error de format.");
			return llegirSiNo(missatge);
		}
	}
}
