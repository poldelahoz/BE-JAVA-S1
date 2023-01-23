package exercisi1;

public class NoticiaBasquet extends Noticia{
	
	private String competicio;
	private String club;
	
	public NoticiaBasquet() {
	}

	public NoticiaBasquet(String titular) {
		super(titular);
	}

	public String getCompeticio() {
		return competicio;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	
	@Override
	public double calcularPreuNoticia() {
		double preu = 250;
		if (competicio.equals("Eurolliga"))
			preu += 75;
		if (club.equals("Barça") || club.equals("Madrid"))
			preu += 75;
		return preu;
	}
	
	@Override
	public Integer calcularPuntuacio() {
		Integer puntuacio = 4;
		if (competicio.equals("Eurolliga"))
			puntuacio += 3;
		if (competicio.equals("ACB"))
			puntuacio += 2;
		if (club.equals("Barça") || club.equals("Madrid"))
			puntuacio += 1;
		return puntuacio;
	}
	
	@Override
	public void demanarInformacio() {
		System.out.println("Introdueix la informació de la notícia:");
		System.out.print("Titular: ");
		this.setTitular(Main.scanner.nextLine());
		System.out.print("Competició: ");
		this.setCompeticio(Main.scanner.nextLine());
		System.out.print("Club: ");
		this.setClub(Main.scanner.nextLine());
	}
	
	@Override
	public void mostrarInformacio() {
		System.out.print("Titular: " + this.getTitular() + " | ");
		System.out.print("Text: " + this.getText() + " | ");
		System.out.print("Competició: " + this.getCompeticio() + " | ");
		System.out.print("Club: " + this.getClub());
	}
}
