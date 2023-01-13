package exercisi2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculoDniTest {
	
	@ParameterizedTest(name = "Calculate letter from number DNI")
	@ValueSource(strings = { "12345678Z", "45678912S", "78912345N", "25836914W", "36914725R", "36925814G", "25814736L", "78945612K", "45612378C", "15975346Y" })
	void correctCalculatedLetter(String dni) {
		char letter = dni.charAt(dni.length()-1);
		Integer dniWithoutLetter = Integer.parseInt(dni.substring(0,dni.length()-1));
		assertEquals(letter,CalculoDni.calculateLetter(dniWithoutLetter),"Wrong letter calculation");
	}
	
}
