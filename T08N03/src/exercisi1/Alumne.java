package exercisi1;

public class Alumne {
	
	private String nom;
	private int edat;
	private String curs;
	private int nota;
	
	public Alumne(String nom, int edat, String curs, int nota) {
		this.nom = nom;
		this.edat = edat;
		this.curs = curs;
		this.nota = nota;
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
	 * @return the edat
	 */
	public int getEdat() {
		return edat;
	}

	/**
	 * @param edat the edat to set
	 */
	public void setEdat(int edat) {
		this.edat = edat;
	}

	/**
	 * @return the curs
	 */
	public String getCurs() {
		return curs;
	}

	/**
	 * @param curs the curs to set
	 */
	public void setCurs(String curs) {
		this.curs = curs;
	}

	/**
	 * @return the nota
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
}
