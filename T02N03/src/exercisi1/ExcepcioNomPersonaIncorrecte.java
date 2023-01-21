package exercisi1;

public class ExcepcioNomPersonaIncorrecte extends Exception{

	private static final long serialVersionUID = 1L;

	public ExcepcioNomPersonaIncorrecte(String errorMessage) {
		super(errorMessage);
	}
	
}
