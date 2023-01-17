package exercisi1;

public class Treballador {
	
	private String nom;
	private String cognom;
	private double preuHora;
	
	public Treballador(String nom, String cognom, double preuHora) {
		this.setNom(nom);
		this.setCognom(cognom);
		this.setPreuHora(preuHora);
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

	public double getPreuHora() {
		return preuHora;
	}

	public void setPreuHora(double preuHora) {
		this.preuHora = preuHora;
	}
	
	public double calcularSou(Integer horesTreballades) {
		return horesTreballades*preuHora;
	}
}
