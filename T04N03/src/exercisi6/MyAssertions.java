package exercisi6;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyAssertions {
	
	@DisplayName("L'excepció ArrayIndexOutOfBoundsException es llança correctament.")
	@Test
	void ensureExceptionIsThrown(){
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
			.as("S'esperava una excepció ArrayIndexOutOfBoundsException")
			.isThrownBy(() -> {
				ProvocaExcepcio.printArrayList();
		});
	}
}
