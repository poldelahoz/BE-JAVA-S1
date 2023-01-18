package exercisi1;

public class NoticiaF1 extends Noticia implements NoticiaUtils{
	
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
	public void calcularPreuNoticia() {
		double preu = 100;
		if (escuderia.equals("Ferrari") || escuderia.equals("Mercedes"))
			preu += 50;
		this.setPreu(preu);
	}
	
	@Override
	public void calcularPuntuacio() {
		Integer puntuacio = 4;
		if (escuderia.equals("Ferrari") || escuderia.equals("Mercedes"))
			puntuacio += 2;
		this.setPuntuacio(puntuacio);
	}
	
	@Override
	public void demanarInformacio() {
		System.out.print("Informació de la notícia");
		System.out.print("Escuderia: ");
		this.setEscuderia(Main.scanner.nextLine());
	}
}
