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

class InstrumentVent extends Instrument{
	
	{
		System.out.println("Instancia d'Instrument de vent creada.");
	}
	
	static{
		System.out.println("Classe d'Instrument de vent carregada.");
	}
	
	public InstrumentVent(String nomInstrument, Double preuInstrument) {
		super(nomInstrument, preuInstrument);
	}

	public void Tocar() {
		System.out.println("Està sonant un instrument de vent");
	}
}

class InstrumentCorda extends Instrument{

	{
		System.out.println("Instancia d'Instrument de corda creada.");
	}
	
	static{
		System.out.println("Classe d'Instrument de corda carregada.");
	}
	
	public InstrumentCorda(String nomInstrument, Double preuInstrument) {
		super(nomInstrument, preuInstrument);
	}

	public void Tocar() {
		System.out.println("Està sonant un instrument de corda");
	}
}

class InstrumentPercussio extends Instrument{

	{
		System.out.println("Instancia d'Instrument de percussió creada.");
	}
	
	static{
		System.out.println("Classe d'Instrument de percussió carregada.");
	}
	
	public InstrumentPercussio(String nomInstrument, Double preuInstrument) {
		super(nomInstrument, preuInstrument);
	}

	public void Tocar() {
		System.out.println("Està sonant un instrument de precussió");
	}
}
	