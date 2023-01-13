package exercisi1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryUtils {
	
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
	
}
