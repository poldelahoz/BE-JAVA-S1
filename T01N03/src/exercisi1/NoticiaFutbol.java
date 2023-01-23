package exercisi1;

public class NoticiaFutbol extends Noticia{
	
	private String competicio;
	private String club;
	private String jugador;
	
	public NoticiaFutbol() {
	}

	public NoticiaFutbol(String titular) {
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

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public double calcularPreuNoticia() {
		double preu = 300;
		if (competicio.equals("Lliga de Campions"))
			preu += 100;
		if (club.equals("Barça") || club.equals("Madrid"))
			preu += 100;
		if (jugador.equals("Ferran Torres") || jugador.equals("Benzema"))
			preu += 50;
		return preu;
	}

	@Override
	public Integer calcularPuntuacio() {
		Integer puntuacio = 5;
		if (competicio.equals("Lliga de Campions"))
			puntuacio += 3;
		if (competicio.equals("Lliga"))
			puntuacio += 2;
		if (club.equals("Barça") || club.equals("Madrid"))
			puntuacio += 1;
		if (jugador.equals("Ferran Torres") || jugador.equals("Benzema"))
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
		System.out.print("Jugador: ");
		this.setJugador(Main.scanner.nextLine());
	}
	
	@Override
	public void mostrarInformacio() {
		System.out.print("Titular: " + this.getTitular() + " | ");
		System.out.print("Text: " + this.getText() + " | ");
		System.out.print("Competició: " + this.getCompeticio() + " | ");
		System.out.print("Club: " + this.getClub() + " | ");
		System.out.print("Jugador: " + this.getJugador());
	}
}
