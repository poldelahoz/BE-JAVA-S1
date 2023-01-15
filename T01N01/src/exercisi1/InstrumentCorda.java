package exercisi1;

public class InstrumentCorda extends Instrument{

	{
		System.out.println("Instancia d'Instrument de corda creada.");
	}
	
	static{
		System.out.println("Classe d'Instrument de corda carregada.");
	}
	
	public InstrumentCorda(String nomInstrument, Double preuInstrument) {
		super(nomInstrument, preuInstrument);
	}
	
	@Override
	public void Tocar() {
		System.out.println("Està sonant un instrument de corda");
	}
}
