package exercisi1;

public class TreballadorPresencial extends Treballador{
	
	private static double benzina;

	public TreballadorPresencial(String nom, String cognom, double preuHora, double benzina) {
		super(nom, cognom, preuHora);
		TreballadorPresencial.benzina = benzina;
	}
	
	@Override
	public double calcularSou(Integer horesTreballades) {
		return horesTreballades * super.getPreuHora() + benzina;
	}
}
