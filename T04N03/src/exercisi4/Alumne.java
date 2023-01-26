package exercisi4;

public class Alumne {
	
	private String nom;
	private int curs;
	private Casa casa;
	
	public static enum Casa {
	    Gryffindor,
	    Hufflepuff,
	    Ravenclaw,
	    Slytherin;
	}
	
	public Alumne(String nom, int curs, Casa casa) {
		this.nom = nom;
		this.curs = curs;
		this.casa = casa;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the curs
	 */
	public int getCurs() {
		return curs;
	}
	/**
	 * @param curs the curs to set
	 */
	public void setCurs(int curs) {
		this.curs = curs;
	}

	/**
	 * @return the casa
	 */
	public Casa getCasa() {
		return casa;
	}

	/**
	 * @param casa the casa to set
	 */
	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
	
}
