package exercisi1;

public class Persona{
	
	private String nom;
	
	private String cognom;
	
	private String DNI;
	
	public Persona() {}
	
	public Persona(String nom, String cognom, String DNI) {
		this.nom = nom;
		this.cognom = cognom;
		this.DNI = DNI;
	}
	
	public Persona(String[] stringArray) {
		this.nom = stringArray[0];
		this.cognom = stringArray[1];
		this.DNI = stringArray[2];
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	
	public void askForInformation() {
		this.nom = Entrada.readString("Introdueix el nom: ");
		this.cognom = Entrada.readString("Introdueix el cognom: ");
		this.DNI = Entrada.readString("Introdueix el DNI: ");
	}
	
	public String[] getFieldsArray() {
		return new String[] {this.nom, this.cognom, this.DNI};
	}
	
	@Override
    public String toString() {
        return this.nom + " " + this.cognom + "	" + this.DNI;
    }
	
	public void print() {
		System.out.printf("%-9s %-17s %-9s \n", this.getNom(), this.getCognom(), this.getDNI());
	}
}
