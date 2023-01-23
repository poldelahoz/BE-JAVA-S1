package exercisi1;

public class NoticiaMotociclisme extends Noticia{
	
	private String equip;
	
	public NoticiaMotociclisme() {
	}

	public NoticiaMotociclisme(String titular) {
		super(titular);
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}
	
	@Override
	public double calcularPreuNoticia() {
		double preu = 100;
		if (equip.equals("Honda") || equip.equals("Yamaha"))
			preu += 50;
		return preu;
	}	
	
	@Override
	public Integer calcularPuntuacio() {
		Integer puntuacio = 3;
		if (equip.equals("Honda") || equip.equals("Yamaha"))
			puntuacio += 3;
		return puntuacio;
	}
	
	@Override
	public void demanarInformacio() {
		System.out.println("Introdueix la informació de la notícia:");
		System.out.print("Titular: ");
		this.setTitular(Main.scanner.nextLine());
		System.out.print("Equip: ");
		this.setEquip(Main.scanner.nextLine());
	}
	
	@Override
	public void mostrarInformacio() {
		System.out.print("Titular: " + this.getTitular() + " | ");
		System.out.print("Text: " + this.getText() + " | ");
		System.out.print("Equip: " + this.getEquip());
	}
}
