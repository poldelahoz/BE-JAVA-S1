package exercisi1;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PrintFiles implements FileVisitor<Path> {
	
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