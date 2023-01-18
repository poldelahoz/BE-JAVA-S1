package exercisi1;

public class Noticia{
	
	private String titular;
	private String text;
	private Integer puntuacio;
	private double preu;
	
	public Noticia() {
	}
	
	public Noticia(String titular) {
		this.titular = titular;
		this.text = "";
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(Integer puntuacio) {
		this.puntuacio = puntuacio;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}
}
