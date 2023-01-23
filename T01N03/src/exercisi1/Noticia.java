package exercisi1;

public abstract class Noticia{
	
	private String titular;
	private String text;
	
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
		return calcularPuntuacio();
	}

	public double getPreu() {
		return calcularPreuNoticia();
	}
	
	abstract double calcularPreuNoticia();
	
	abstract Integer calcularPuntuacio();
	
	abstract void demanarInformacio();
	
	abstract void mostrarInformacio();
}
