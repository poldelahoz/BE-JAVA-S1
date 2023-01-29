package exercisi1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CsvFileUtils {
	
	public static List<String[]> read(Path path) throws Exception{
		try (Reader reader = Files.newBufferedReader(path)) {
	        try (CSVReader csvReader = new CSVReader(reader)) {
	            return csvReader.readAll();
	        }
	    }
	}
	
	public static void writeLine(String filePath, String[] data) throws IOException {
	    try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath, true), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
	        csvWriter.writeNext(data);
	    }
	}
	
}
