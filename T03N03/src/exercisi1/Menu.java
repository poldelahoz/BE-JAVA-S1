package exercisi1;

public class Menu {
	
	private final String[] options;
	
	public Menu(String[] options) {
		this.options = options;
	}
	
	/**
	 * @return the options
	 */
	public String[] getOptions() {
		return options;
	}
	
	/**
	 * @return the options length
	 */
	public Integer getOptionsLength() {
		return options.length;
	}
	
	public int printMenu() {
		System.out.println();
		System.out.println("--------------------------- MENÚ ---------------------------");
		for (String option : this.options){
            System.out.println(option);
        }
		System.out.println();
		return Entrada.readInt("Tria una opció: ");
	}
}
