package es.vive.libre.common;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.vive.libre.model.Book;

public class Utils {
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN);
	
	public static List<Book> loadData() throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();

        try {
        	
        	InputStream is = Utils.class.getClassLoader().getResourceAsStream(Constants.FILE_NAME);
            return objectMapper.readValue(is, new TypeReference<List<Book>>() {});
            
        } catch (IOException e) {
            throw e;
        }
	}
	
	public static LocalDate timestampToLocalDate(String rawTimestamp) {
		long timestamp = Long.valueOf(rawTimestamp);
		return Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static String formatLocalDate(LocalDate date) {
		return DATE_FORMATTER.format(date);
	}

}
