package exercisi2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueix un directori complert:");
		String dir = scanner.nextLine();
		/*List<String> directoryContent = DirectoryUtils.listContentOrdered(dir);
		System.out.println("Contingut ordenat alfabéticament del directori " + path + ":");
		directoryContent.forEach(System.out::println);*/
		
		DirectoryUtils.listAllSubdirectoriesAndFiles(dir);
	}

}
