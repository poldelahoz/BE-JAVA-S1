package exercisis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryUtils {
	
	public static void printContentOrdered(String dir) {
		try (Stream<Path> stream = Files.list(Paths.get(dir))) {
			List<String> directoryContent =stream
	          .map(Path::getFileName)
	          .map(Path::toString)
	          .sorted()
	          .collect(Collectors.toList());
			directoryContent.forEach(System.out::println);
	    }catch(IOException e) {
	    	System.out.println("Path " + dir + "does not exist.\n" + e.getMessage());
	    }
	}
	
	public static void printAllSubdirectoriesAndFiles(String dir){
		try {
			Path startingDir = Paths.get(dir);
			PrintFiles printFiles = new PrintFiles();
			EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
			Files.walkFileTree(startingDir, opts, Integer.MAX_VALUE, printFiles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveAllSubdirectoriesAndFiles(String dir){
		try {
			Path startingDir = Paths.get(dir);
			SaveFiles saveFiles = new SaveFiles();
			EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
			Files.walkFileTree(startingDir, opts, Integer.MAX_VALUE, saveFiles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printFile(String dir) {
		try {
			File file = new File(dir);
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNextLine()) {
				System.out.println(fileReader.nextLine());
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existeix el fitxer " + dir);
		}
	}
	
	public static void seralizeObject() {
		
	}
}