package exercisi1;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Redaccio {
	
	private ArrayList<Redactor> redactors = new ArrayList<Redactor>();
	private static double sou;
	
	public Redaccio(double sou) {
		Redaccio.setSou(sou);
	}

	/**
	 * @return the redactors
	 */
	public ArrayList<Redactor> getRedactors() {
		return redactors;
	}
	
	/**
	 * @return the redactor with Dni/Nom in redactors or null
	 */
	public Redactor getRedactor(String DniNom) { 
        // filter
        Predicate<Redactor> dniFilter = redactor -> DniNom.equals(redactor.getDNI());
        
        return redactors.stream().filter(dniFilter).findAny().orElse(null);
	}
	
	/**
	 * @return the sou
	 */
	public static double getSou() {
		return sou;
	}

	/**
	 * @param sou the sou to set
	 */
	public static void setSou(double sou) {
		Redaccio.sou = sou;
	}
	
	/**
	 * @param redactor the redactor to add to redactors
	 */
	public boolean afegirRedactor(Redactor redactor) {
		try {
			redactors.add(redactor);
			return true;
		}catch(Exception e){
			System.err.println("No s'ha pogut afegir el redactor: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * @param redactor the redactor to remove from redactors
	 */
	public void borrarRedactor(Redactor redactor) {
		redactors.remove(redactor);
	}

}
