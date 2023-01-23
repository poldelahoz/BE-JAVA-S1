package exercisi2;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercisi2.Alumne.Casa;

public class MyAssertions {
	
	@DisplayName("La referencia a un objecte és la mateixa que una altra.")
	@Test
    void ensureReferenceEqual( ) {
		Alumne alumne1 = new Alumne("Harry Potter", 1, Casa.Gryffindor);
		Alumne alumne2 = alumne1;
		assertThat(alumne1.hashCode()).as("La referencia a l'alumne1 no és la mateixa que la de l'alumne2").isEqualTo(alumne2.hashCode());
    }
    
	@DisplayName("La referencia a un objecte és diferent que una altra.")
	@Test
    void ensureReferenceNotEqual( ) {
		Alumne alumne1 = new Alumne("Harry Potter", 1, Casa.Gryffindor);
		Alumne alumne2 = new Alumne("Draco Malfoy", 1, Casa.Slytherin);
		assertThat(alumne1.hashCode()).as("La referencia a l'alumne1 no és diferent a la de l'alumne2").isNotEqualTo(alumne2.hashCode());
    }
	
}
