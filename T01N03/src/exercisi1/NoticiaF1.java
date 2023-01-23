package exercisi1;

public class NoticiaF1 extends Noticia{
	
	private String escuderia;
	
	public NoticiaF1() {
	}

	public NoticiaF1(String titular) {
		super(titular);
	}
	
	public String getEscuderia() {
		return escuderia;
	}
	
	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}
	
	@Override
	public double calcularPreuNoticia() {
		double preu = 100;
		if (escuderia.equals("Ferrari") || escuderia.equals("Mercedes"))
			preu += 50;
		return preu;
	}
	
	@Override
	public Integer calcularPuntuacio() {
		Integer puntuacio = 4;
		if (escuderia.equals("Ferrari") || escuderia.equals("Mercedes"))
			puntuacio += 2;
		return puntuacio;
	}
	
	@Override
	public void demanarInformacio() {
		System.out.println("Introdueix la informació de la notícia:");
		System.out.print("Titular: ");
		this.setTitular(Main.scanner.nextLine());
		System.out.print("Escuderia: ");
		this.setEscuderia(Main.scanner.nextLine());
	}
	
	@Override
	public void mostrarInformacio() {
		System.out.print("Titular: " + this.getTitular() + " | ");
		System.out.print("Text: " + this.getText() + " | ");
		System.out.print("Escuderia: " + this.getEscuderia());
	}
}
