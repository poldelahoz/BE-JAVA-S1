package exercisi1;

public class NoticiaTenis extends Noticia implements NoticiaUtils{
	
	private String competicio;
	private String tenista;
	
	public NoticiaTenis() {
	}

	public NoticiaTenis(String titular) {
		super(titular);
	}
	
	public String getCompeticio() {
		return competicio;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}

	public String getTenista() {
		return tenista;
	}

	public void setTenista(String tenista) {
		this.tenista = tenista;
	}
	
	@Override
	public void calcularPreuNoticia() {
		double preu = 150;
		if (tenista.equals("Federer") || tenista.equals("Nadal") || tenista.equals("Djokovic"))
			preu += 100;
		this.setPreu(preu);
	}
	
	@Override
	public void calcularPuntuacio() {
		Integer puntuacio = 4;
		if (tenista.equals("Federer") || tenista.equals("Nadal") || tenista.equals("Djokovic"))
			puntuacio += 3;
		this.setPuntuacio(puntuacio);
	}
	
	@Override
	public void demanarInformacio() {
		System.out.print("Informació de la notícia");
		System.out.print("Competició: ");
		this.setCompeticio(Main.scanner.nextLine());
		System.out.print("Tenista: ");
		this.setTenista(Main.scanner.nextLine());
	}
}
