package exercisi1;

public class InstrumentVent extends Instrument{
	
	{
		System.out.println("Instancia d'Instrument de vent creada.");
	}
	
	static{
		System.out.println("Classe d'Instrument de vent carregada.");
	}
	
	public InstrumentVent(String nomInstrument, Double preuInstrument) {
		super(nomInstrument, preuInstrument);
	}
	
	@Override
	public void Tocar() {
		System.out.println("Està sonant un instrument de vent");
	}
}
