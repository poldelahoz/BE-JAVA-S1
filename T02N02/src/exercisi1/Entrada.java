package exercisi1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static byte llegirByte(String missatge) {
		try {
			System.out.println(missatge);
			byte b = scanner.nextByte();
			scanner.nextLine();
			return b;
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return llegirByte(missatge);
		}
	}
	
	public static int llegirInt(String missatge) {
		try {
			System.out.println(missatge);
			int i = scanner.nextInt();
			scanner.nextLine();
			return i;
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return llegirInt(missatge);
		}
	}
	
	public static float llegirFloat(String missatge) {
		try {
			System.out.println(missatge);
			float f = scanner.nextFloat();
			scanner.nextLine();
			return f;
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return llegirFloat(missatge);
		}
	}
	
	public static double llegirDouble(String missatge) {
		try {
			System.out.println(missatge);
			double d = scanner.nextDouble();
			scanner.nextLine();
			return d;
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return llegirDouble(missatge);
		}
	}
	
	public static char llegirChar(String missatge) {
		try {
			System.out.println(missatge);
			String out = scanner.nextLine();
			if (out.length() == 1)
				return out.charAt(0);
			else
				throw new Exception();
		}catch(Exception e) {
			System.out.println("Error de format.");
			return llegirChar(missatge);
		}
	}
	
	public static String llegirString(String missatge) {
		try {
			System.out.println(missatge);
			String out = scanner.nextLine();
			return out;
		}catch(Exception e) {
			System.out.println("Error de format.");
			return llegirString(missatge);
		}
	}
	
	public static boolean llegirSiNo(String missatge) {
		try {
			System.out.println(missatge);
			String out = scanner.nextLine();
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
