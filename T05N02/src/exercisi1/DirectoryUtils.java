package exercisi1;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class DirectoryUtils {
	
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
	
}
