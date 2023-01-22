package exercisi5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyAssertions {
	
	private static final String USERNAME_KEY = "pol";
    private static final String USERNAME_VALUE = "informatic";
	
	@DisplayName("Un Map conté una de les Key que li afegeix.")
	@Test
	void ensureMapConatinsAnInsertedKey() {
		Map<String, String> map = new HashMap<>();
		map.put(USERNAME_KEY, USERNAME_VALUE);
		assertThat(map)
			.as("El map no conté la key %s.", USERNAME_KEY)
			.containsKey(USERNAME_KEY);
	}
}
