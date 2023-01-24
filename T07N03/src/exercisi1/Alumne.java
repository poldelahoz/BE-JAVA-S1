package exercisi1;

@JsonSerializable(savePath = "C:\\SerializedObjects\\")
public class Alumne {
	
	@JsonElement(name = "nom")
	private String nom;
	
	@JsonElement(name = "cognom")
	private String cognom;
	
	@JsonElement(name = "curs")
	private int curs;
	
	@JsonElement(name = "casa")
	private Casa casa;
	
	public static enum Casa {
	    Gryffindor,
	    Hufflepuff,
	    Ravenclaw,
	    Slytherin;
	}
	
	public Alumne(String nom, String cognom, int curs, Casa casa) {
		this.nom = nom;
		this.cognom = cognom;
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
	 * @return the cognom
	 */
	public String getCognom() {
		return cognom;
	}

	/**
	 * @param cognom the cognom to set
	 */
	public void setCognom(String cognom) {
		this.cognom = cognom;
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
