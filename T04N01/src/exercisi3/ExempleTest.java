package exercisi3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExempleTest {

	@Test
    @DisplayName("throws ArrayIndexOutOfBoundsException when calling method()")
    void throwsExceptionWhenPopped() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> Exemple.method());
        assertEquals(new ArrayIndexOutOfBoundsException().getClass(), exception.getClass());
    }

}
