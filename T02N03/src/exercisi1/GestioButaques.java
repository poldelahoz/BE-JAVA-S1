package exercisi1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GestioButaques {
	
	private final ArrayList<Butaca> butaques;
	
	public GestioButaques() {
		butaques = new ArrayList<Butaca>();
	}

	/**
	 * @return the butaques
	 */
	public ArrayList<Butaca> getButaques(){
		return butaques;
	}
	
	public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
		int i = cercarButaca(butaca.getnFila(), butaca.getnSeient());
		if (i == -1) {
			butaques.add(butaca);
			Comparator<Butaca> compareByFilaSeient = Comparator
                    									.comparing(Butaca::getnFila)
                    									.thenComparing(Butaca::getnSeient);
			Collections.sort(butaques, compareByFilaSeient);
		}else
			throw new ExcepcioButacaOcupada("Aquesta butaca ja està ocupada.");
	}
	
	public void eliminarButaca(Integer nFila, Integer nSeient) throws ExcepcioButacaLliure {
		int i = cercarButaca(nFila, nSeient);
		if (i != -1)
			butaques.remove(butaques.get(i));
		else
			throw new ExcepcioButacaLliure("Aquesta butacada està lliure.");
	}
	
	private int cercarButaca(Integer nFila, Integer nSeient) {
		return IntStream.range(0, butaques.size())
				.filter(i -> butaques.get(i).getnFila().equals(nFila))
				.filter(i -> butaques.get(i).getnSeient().equals(nSeient))
                .findFirst()
                .orElse(-1);
	}
	
	public List<Butaca> cercarButaquesPersona(String persona) {
		return butaques.stream().filter(b -> b.getPersona().equals(persona)).collect(Collectors.toList());
	}
}
