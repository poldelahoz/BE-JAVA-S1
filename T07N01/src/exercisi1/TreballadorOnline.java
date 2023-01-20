package exercisi1;

public class TreballadorOnline extends Treballador{
	
	private static double internet;

	public TreballadorOnline(String nom, String cognom, double preuHora, double internet) {
		super(nom, cognom, preuHora);
		TreballadorOnline.internet = internet;
	}
	
	@Override
	public double calcularSou(Integer horesTreballades) {
		return horesTreballades * super.getPreuHora() + internet;
	}
}
