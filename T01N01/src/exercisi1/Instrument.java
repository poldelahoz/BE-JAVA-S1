package exercisi1;

public abstract class Instrument {
	
	private String nom;
	private Double preu;

	public Instrument(String nomInstrument, Double preuInstrument) {
		nom = nomInstrument;
		preu = preuInstrument;
	}
	
	public void SetNom(String nomInstrument) {
		nom = nomInstrument;
	}
	
	public void SetPreu(Double preuInstrument) {
		preu = preuInstrument;
	}
	
	public String GetNom() {
		return nom;
	}
	
	public Double GetPreu() {
		return preu;
	}
	
	abstract void Tocar();
}
