package exercisi7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyAssertions {
	
	@DisplayName("Un Optinal està buit.")
	@Test
	void ensureEmptyObject() {
		Optional<Object> optional = Optional.empty();
		assertThat(optional).isEmpty();
	}
}
