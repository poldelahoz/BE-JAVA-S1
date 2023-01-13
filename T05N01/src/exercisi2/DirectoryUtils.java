package exercisi2;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.nio.file.FileVisitResult.*;

public class DirectoryUtils {
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	public static List<String> listContentOrdered(String path) {
		try (Stream<Path> stream = Files.list(Paths.get(path))) {
	        return stream
	          .map(Path::getFileName)
	          .map(Path::toString)
	          .sorted()
	          .collect(Collectors.toList());
	    }catch(IOException e) {
	    	System.out.println("Path " + path + "does not exist.\n" + e.getMessage());
	    	return null;
	    }
	}
	
	public static void listAllSubdirectoriesAndFiles(String path){
		try {
			Path startingDir = Paths.get(path);
			PrintFiles printFiles = new PrintFiles();
			EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
			Files.walkFileTree(startingDir, opts, Integer.MAX_VALUE, printFiles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String formatDateTime(FileTime fileTime) {
        LocalDateTime localDateTime = fileTime
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return localDateTime.format(DATE_FORMATTER);
    }
}

class PrintFiles implements FileVisitor<Path> {
	
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
	    System.out.println("(" + DirectoryUtils.formatDateTime(attr.lastModifiedTime()) + ")");
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
		    System.out.println("(" + DirectoryUtils.formatDateTime(attr.lastModifiedTime()) + ")");
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
