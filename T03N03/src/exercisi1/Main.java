package exercisi1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	private static final String rootPath = System.getProperty("user.dir") + "\\";
	public static final String filePath = rootPath + "llistatPersones.csv";
	public static final Path savePath = Paths.get(filePath);
	public static List<Persona> persones;

	public static void main(String[] args) {
		
		Menu menu = new Menu(new String[] {
				"1.- Introduir persona.",
				"2.- Mostrar les persones ordenades per nom (A-Z).",
				"3.- Mostrar les persones ordenades per nom (Z-A).",
				"4.- Mostrar les persones ordenades per cognoms (A-Z).",
				"5.- Mostrar les persones ordenades per cognoms (Z-A).",
				"6.- Mostrar les persones ordenades per DNI (1-9).",
				"7.- Mostrar les persones ordenades per DNI (9-1).",
				"0.- Sortir."
		});
		
		updatePersones();
		
		int option;
        boolean exit = false;
		while (!exit){
        	option = menu.printMenu();
            switch (option){
                case 1: MenuOptions.option1(); break;
                case 2: MenuOptions.option2(); break;
                case 3: MenuOptions.option3(); break;
                case 4: MenuOptions.option4(); break;
                case 5: MenuOptions.option5(); break;
                case 6: MenuOptions.option6(); break;
                case 7: MenuOptions.option7(); break;
                case 0: System.out.println("Fins aviat!"); exit = true; break;
                default: System.out.println("Només números entre 0 i 7");
            }
		}
	}
	
	public static void updatePersones() {
		try {
			persones = CsvFileUtils.read(savePath)
				.stream()
				.map(c -> new Persona(c))
				.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
