package exercisi1;

public class Main {
	
	private static InstrumentVent iVent;
	private static InstrumentCorda iCorda;
	private static InstrumentPercussio iPercussio;
	
	public static void main(String[] args) {
		iVent = new InstrumentVent("Flauta", 9.00);
		iCorda = new InstrumentCorda("Guitarra", 46.00);
		iPercussio = new InstrumentPercussio("Tambor", 27.00);
		iVent.Tocar();
		iCorda.Tocar();
		iPercussio.Tocar();
		iCorda = new InstrumentCorda("Violí", 40.00);
	}
}
