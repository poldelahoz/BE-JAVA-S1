package exercisi2;

import java.util.ArrayList;

public class CalculoDni {
	
	private static ArrayList<Integer> dnis;
	
	public CalculoDni() {
		dnis = new ArrayList<Integer>();
		dnis.add(12345678);
		dnis.add(45678912);
		dnis.add(78912345);
		dnis.add(25836914);
		dnis.add(36914725);
		dnis.add(36925814);
		dnis.add(25814736);
		dnis.add(78945612);
		dnis.add(45612378);
		dnis.add(15975346);
	}
	
	public static ArrayList<Integer> getName() {
		return dnis;
	}
	
	public static char calculateLetter(Integer dni) {
		String characters="TRWAGMYFPDXBNJZSQVHLCKE";
		int remain = dni%23;
		return characters.charAt(remain);
	}
}
