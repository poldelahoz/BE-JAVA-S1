package exercisi2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueix un directori complert:");
		String dir = scanner.nextLine();
		scanner.close();
		System.out.println();
		System.out.println("Arbre complet del directori " + dir + ":");
		DirectoryUtils.listAllSubdirectoriesAndFiles(dir);
	}

}
