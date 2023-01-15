package exercisi1;

public class InstrumentPercussio extends Instrument{

	{
		System.out.println("Instancia d'Instrument de percussió creada.");
	}
	
	static{
		System.out.println("Classe d'Instrument de percussió carregada.");
	}
	
	public InstrumentPercussio(String nomInstrument, Double preuInstrument) {
		super(nomInstrument, preuInstrument);
	}
	
	@Override
	public void Tocar() {
		System.out.println("Està sonant un instrument de precussió");
	}
}
