package exercisi1;

public class Butaca{
	
	private Integer nFila;
	private Integer nSeient;
	private String persona;
	
	public Butaca(Integer nFila, Integer nSeient, String persona) {
		this.nFila = nFila;
		this.nSeient = nSeient;
		this.persona = persona;
	}

	/**
	 * @return the nFila
	 */
	public Integer getnFila() {
		return nFila;
	}

	/**
	 * @param nFila the nFila to set
	 */
	public void setnFila(Integer nFila) {
		this.nFila = nFila;
	}

	/**
	 * @return the nSeient
	 */
	public Integer getnSeient() {
		return nSeient;
	}

	/**
	 * @param nSeient the nSeient to set
	 */
	public void setnSeient(Integer nSeient) {
		this.nSeient = nSeient;
	}

	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}
	
	public boolean Equals(Butaca butaca) {
	    if (this == butaca) return true;
	    if (butaca == null) return false;
	    return nFila.equals(butaca.nFila) && nSeient.equals(butaca.nSeient);
	}
	
	@Override
	public String toString() {
		return "Fila: " + nFila + ", Seient:" + nSeient + ", Persona: " + persona;
	}
}
