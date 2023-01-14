package exercisis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.FileVisitResult.*;

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
			File countriesFile = new File(dir);
			Scanner fileReader = new Scanner(countriesFile);
			while (fileReader.hasNextLine()) {
				System.out.println(fileReader.nextLine());
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existeix el fitxer " + dir);
		}
	}
	
}

class PrintFiles implements FileVisitor<Path> {
	
	private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	private String formatDateTime(FileTime fileTime) {
        LocalDateTime localDateTime = fileTime
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return localDateTime.format(DATE_FORMATTER);
    }
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		Integer level = file.getNameCount();
		for(int i = 1; i < level; i++) {
			if (i+1 == level) {
				System.out.print("-->");
			}else {
				System.out.print("   ");
			}
		}
	    if (attr.isRegularFile()) {
	        System.out.format("%s (F) | ", file.getFileName());
	    } else if (attr.isDirectory()) {
	        System.out.format("%s (D) | ", file.getFileName());
	    } else {
	        System.out.format("Other: %s ", file);
	    }
	    System.out.println("(" + formatDateTime(attr.lastModifiedTime()) + ")");
	    return CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		try{
			Integer level = dir.getNameCount();
			for(int i = 1; i < level; i++) {
				if (i+1 == level) {
					System.out.print("-->");
				}else {
					System.out.print("   ");
				}
			}
			BasicFileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);
			System.out.format("%s (D) | ", dir.getFileName());
		    System.out.println("(" + formatDateTime(attr.lastModifiedTime()) + ")");
		    return CONTINUE;
		}catch(IOException e) {
			e.printStackTrace();
			return CONTINUE;
		}
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		return CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) {
	    System.err.println(exc);
	    return CONTINUE;
	}
}

class SaveFiles implements FileVisitor<Path> {
	
	private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	private String formatDateTime(FileTime fileTime) {
        LocalDateTime localDateTime = fileTime
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return localDateTime.format(DATE_FORMATTER);
    }
	
	private static void saveToFile(String data){
		try {
			String dateTime = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
			Files.createDirectories(Paths.get(Main.savePath));
			String fullSavePath = Main.savePath + "DirectoryTree_" + dateTime + ".txt";
			File file = new File(fullSavePath);
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(fullSavePath, true);
			fileWriter.write(data + System.lineSeparator());
			fileWriter.flush();
			fileWriter.close();
		}catch(IOException e) {
			System.out.println("An error occurred writing the file.\n" + e.getMessage());
		}
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		String data = "";
		Integer level = file.getNameCount();
		for(int i = 1; i < level; i++) {
			if (i+1 == level) {
				data += "-->";
			}else {
				data += "   ";
			}
		}
	    if (attr.isRegularFile()) {
	    	data += file.getFileName() + " (F) | ";
	    } else {
	    	data += file + "Other: %s ";
	    }
	    data += "(" + formatDateTime(attr.lastModifiedTime()) + ")";
	    saveToFile(data);
	    return CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		try{
			String data = "";
			Integer level = dir.getNameCount();
			for(int i = 1; i < level; i++) {
				if (i+1 == level) {
					data += "-->";
				}else {
					data += "   ";
				}
			}
			BasicFileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);
			data += dir.getFileName() + " (D) | ";
			data += "(" + formatDateTime(attr.lastModifiedTime()) + ")";
			saveToFile(data);
		    return CONTINUE;
		}catch(IOException e) {
			e.printStackTrace();
			return CONTINUE;
		}
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		return CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) {
	    System.err.println(exc);
	    return CONTINUE;
	}
}
