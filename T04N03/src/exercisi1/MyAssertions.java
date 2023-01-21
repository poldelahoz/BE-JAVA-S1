package exercisi1;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercisi1.Alumne.Casa;

public class MyAssertions {
	
	@DisplayName("Dos alumnes son iguals")
	@Test
    void ensureEqual( ) {
		Alumne alumne1 = new Alumne("Harry Potter", 1, Casa.Gryffindor);
		Alumne alumne2 = new Alumne("Harry Potter", 1, Casa.Gryffindor);
		assertThat(alumne1).isEqualTo(alumne2);
    }
    
	@DisplayName("Dos alumnes son diferents")
	@Test
    void ensureNotEqual( ) {
		Alumne alumne1 = new Alumne("Harry Potter", 1, Casa.Gryffindor);
		Alumne alumne2 = new Alumne("Draco Malfoy", 1, Casa.Slytherin);
		assertThat(alumne1).isNotEqualTo(alumne2);
    }
	
	
}
