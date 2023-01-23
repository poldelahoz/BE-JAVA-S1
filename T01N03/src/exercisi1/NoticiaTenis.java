package exercisi1;

public class NoticiaTenis extends Noticia{
	
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
	public double calcularPreuNoticia() {
		double preu = 150;
		if (tenista.equals("Federer") || tenista.equals("Nadal") || tenista.equals("Djokovic"))
			preu += 100;
		return preu;
	}
	
	@Override
	public Integer calcularPuntuacio() {
		Integer puntuacio = 4;
		if (tenista.equals("Federer") || tenista.equals("Nadal") || tenista.equals("Djokovic"))
			puntuacio += 3;
		return puntuacio;
	}
	
	@Override
	public void demanarInformacio() {
		System.out.println("Introdueix la informació de la notícia:");
		System.out.print("Titular: ");
		this.setTitular(Main.scanner.nextLine());
		System.out.print("Competició: ");
		this.setCompeticio(Main.scanner.nextLine());
		System.out.print("Tenista: ");
		this.setTenista(Main.scanner.nextLine());
	}
	
	@Override
	public void mostrarInformacio() {
		System.out.print("Titular: " + this.getTitular() + " | ");
		System.out.print("Text: " + this.getText() + " | ");
		System.out.print("Competició: " + this.getCompeticio() + " | ");
		System.out.print("Tenista: " + this.getTenista());
	}
}
