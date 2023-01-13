package exercisi1;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueix un directori complert:");
		String path = scanner.nextLine();
		scanner.close();
		List<String> directoryContent = DirectoryUtils.listContentOrdered(path);
		System.out.println("Contingut ordenat alfabéticament del directori " + path + ":");
		directoryContent.forEach(System.out::println);
	}

}
