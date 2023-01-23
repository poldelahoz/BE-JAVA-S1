package exercisi1;

public class Menu {
	
	private final String[] options;
	private final MenuType menuType;
	
	public static enum MenuType{
		PRINCIPAL,
		TIPUS_DE_NOTICIA
	}
	
	public Menu(String[] options, MenuType menuType) {
		this.options = options;
		this.menuType = menuType;
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
	
	public void printMenu() {
		switch (this.menuType){
	        case PRINCIPAL: 
	        	System.out.println();
				System.out.println("--------------------------- MENÚ ---------------------------");
				for (String option : this.options){
		            System.out.println(option);
		        }
				System.out.println();
		        System.out.print("Tria una opció: ");
	        	break;
	        case TIPUS_DE_NOTICIA:
	        	System.out.println("Quin tipus de notícia vols insertar? ");
				for (String option : this.options){
		            System.out.println(option);
		        }
				System.out.println();
		        System.out.print("Tria una opció: ");
	        	break;
		}
		if (this.menuType.equals(MenuType.PRINCIPAL)) {
			
		}
	}
}
