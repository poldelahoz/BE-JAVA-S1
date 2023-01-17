package exercisi2;

public class Persona {
	private String nom;
	private String cognom;
	private Integer edat;
	
	public Persona(String nom, String cognom, Integer edat) {
		this.nom = nom;
		this.cognom = cognom;
		this.edat = edat;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCognom() {
		return cognom;
	}
	
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	
	public Integer getEdat() {
		return edat;
	}
	
	public void setEdat(Integer edat) {
		this.edat = edat;
	}
	
	
	
}
