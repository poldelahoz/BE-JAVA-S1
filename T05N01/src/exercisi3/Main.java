package exercisi3;

import java.util.Scanner;

public class Main {
	
	public static final String savePath = "src/exercisi3/resources/";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueix un directori complert:");
		String dir = scanner.nextLine();
		scanner.close();
		System.out.println();
		DirectoryUtils.listAllSubdirectoriesAndFiles(dir);
		System.out.println("Arbre complet del directori guardat a " + savePath);
	}

}
