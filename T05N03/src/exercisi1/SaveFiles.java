package exercisi1;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import java.util.Locale;

public class SaveFiles implements FileVisitor<Path> {
	
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
			FileWriter fileWriter = new FileWriter(Main.rootPath + "temp.txt", true);
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
