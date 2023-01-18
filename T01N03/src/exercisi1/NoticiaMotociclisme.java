package exercisi1;

public class NoticiaMotociclisme extends Noticia implements NoticiaUtils{
	
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
	public void calcularPreuNoticia() {
		double preu = 100;
		if (equip.equals("Honda") || equip.equals("Yamaha"))
			preu += 50;
		this.setPreu(preu);
	}	
	
	@Override
	public void calcularPuntuacio() {
		Integer puntuacio = 3;
		if (equip.equals("Honda") || equip.equals("Yamaha"))
			puntuacio += 3;
		this.setPuntuacio(puntuacio);
	}
	
	@Override
	public void demanarInformacio() {
		System.out.print("Informació de la notícia");
		System.out.print("Equip: ");
		this.setEquip(Main.scanner.nextLine());
	}
}
