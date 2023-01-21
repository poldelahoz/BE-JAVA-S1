package exercisi1;

import java.time.temporal.ValueRange;
import java.util.List;

public class Cine {
	
	private Integer nFiles;
	private Integer nSeients;
	private GestioButaques gestioButaques;
	
	public Cine() {
		gestioButaques = new GestioButaques();
		demanarDadesInicials();
	}
	
	public void iniciar() {
		int option;
        boolean exit = false;
		while (!exit){
        	option = menu();
            switch (option){
                case 1: mostrarButaques(); break;
                case 2: mostrarButaquesPersona(); break;
                case 3: reservarButaca(); break;
                case 4: anularReserva(); break;
                case 5: anularReservaPersona(); break;
                case 0: System.out.println("Fins aviat!"); exit = true; break;
                default: System.out.println("Només números entre 0 i 5");
            }
		}
	}
	
	private int menu() {
		String[] options = {
				"1.- Mostrar totes les butaques reservades.",
	            "2.- Mostrar les butaques reservades per una persona.",
	            "3.- Reservar una butaca.",
	            "4.- Anul·lar la reserva d’una butaca.",
	            "5.- Anul·lar totes les reserves d’una persona.",
	            "0.- Sortir",
		};
		System.out.println();
		System.out.println("--------------------------- MENÚ ---------------------------");
		for (String option : options){
            System.out.println(option);
        }
		System.out.println();
        return Entrada.llegirInt("Tria una opció: ");
	}
	
	public void mostrarButaques() {
		if(gestioButaques.getButaques().size() != 0) {
			System.out.println("Butaques reservades: ");
			gestioButaques.getButaques().forEach(butaca -> System.out.println("Fila: " + butaca.getnFila() + " | Seient: " + butaca.getnSeient()));
		}else
			System.out.println("No hi ha cap butaca reservada.");
	}
	
	public void mostrarButaquesPersona() {
		String persona = Entrada.llegirString("Introdueix el nom de la persona que ha reservat: ");
		List<Butaca> butaquesPersona = gestioButaques.cercarButaquesPersona(persona);
		if(butaquesPersona.size() > 0){
			System.out.println("Butaques reservades per " + persona + ": ");
			butaquesPersona.forEach(butaca -> System.out.println("Fila: " + butaca.getnFila() + " | Seient: " + butaca.getnSeient()));
		}else {
			System.out.println("Aquesta persona no té cap butaca reserva.");
		}
	}
	
	public void reservarButaca() {
		int nFila;
		int nSeient;
		String persona;
		try {
			nFila = introduirFila();
			nSeient = introduirSeient();
			persona = introduirPersona();
			gestioButaques.afegirButaca(new Butaca(nFila, nSeient, persona));
			System.out.println();
			System.out.println("Butaca reservada.");
		} catch (ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());
		} catch (ExcepcioSeientIncorrecte e) {
			System.out.println(e.getMessage());
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println(e.getMessage());
		} catch (ExcepcioButacaOcupada e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void anularReserva() {
		int nFila;
		int nSeient;
		try {
			nFila = introduirFila();
			nSeient = introduirSeient();
			gestioButaques.eliminarButaca(nFila, nSeient);
			System.out.println();
			System.out.println("Reserva anulada.");
		} catch (ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());
		} catch (ExcepcioSeientIncorrecte e) {
			System.out.println(e.getMessage());
		} catch (ExcepcioButacaLliure e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void anularReservaPersona() {
		try {
			String persona = introduirPersona();
			List<Butaca> butaquesPersona = gestioButaques.cercarButaquesPersona(persona);
			if(butaquesPersona.size() > 0){
				butaquesPersona.forEach(butaca -> {
					try {
						gestioButaques.eliminarButaca(butaca.getnFila(), butaca.getnSeient());
					} catch (ExcepcioButacaLliure e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				System.out.println("Reserva/es anulada/es.");
			}else {
				System.out.println("Aquesta persona no té cap butaca reservada.");
			}
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println(e.getMessage());
		}
	}
	
	private String introduirPersona() throws ExcepcioNomPersonaIncorrecte{
		try {
			String persona = Entrada.llegirString("Nom i cognom de la persona: ");
			if(!persona.matches(".*\\d.*"))
				return persona;
			else	
				throw new ExcepcioNomPersonaIncorrecte("Nom de la persona incorrecte.");
		}catch(ExcepcioNomPersonaIncorrecte e) {
			System.out.println(e.getMessage());
			return introduirPersona();
		}
	}
	
	private void demanarDadesInicials() {
		nFiles = Entrada.llegirInt("Nombre de files: ");
		nSeients = Entrada.llegirInt("Nombre de seients per fila: ");
	}
	
	private int introduirFila() throws ExcepcioFilaIncorrecta{
		try {
			int nFila = Entrada.llegirInt("Nombre de fila: ");
			ValueRange range = ValueRange.of(1, nFiles);
			if(range.isValidIntValue(nFila))
				return nFila;
			else	
				throw new ExcepcioFilaIncorrecta("Nombre de fila incorrecta. El cine només té " + nFiles + " files.");
		}catch(ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());
			return introduirFila();
		}
	}
	
	private int introduirSeient() throws ExcepcioSeientIncorrecte{
		try {
			int nSeient = Entrada.llegirInt("Nombre de seient: ");
			ValueRange range = ValueRange.of(1, nSeients);
			if(range.isValidIntValue(nSeient))
				return nSeient;
			else	
				throw new ExcepcioSeientIncorrecte("Nombre de seient incorrecte. El cine només té " + nSeients + " seients per fila.");
		}catch(ExcepcioSeientIncorrecte e) {
			System.out.println(e.getMessage());
			return introduirSeient();
		}
	}
}
