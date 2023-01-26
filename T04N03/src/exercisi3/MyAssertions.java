package exercisi3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyAssertions {
	
	@DisplayName("Dos Arrays d'enters són idèntics.")
	@Test
	void intArraysEqual() {
		Integer[] array1 = new Integer[]{1,2,3,4,5};
		Integer[] array2 = new Integer[]{5,4,3,2,1};
		
		assertThat(array1)
			.as("Els arrays no són idèntics.")
			.containsExactly(array2);
	}
}
