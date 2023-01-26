package exercisi4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercisi4.Alumne.Casa;

public class MyAssertions {
	
	private ArrayList<Object> arrayList;
	private Alumne object1;
	private MonthsList object2;
	private Restaurant object3;
	private Alumne object4;
	
	@BeforeEach
    void creationAndInitializationList() {
		arrayList = new ArrayList<Object>();
		object1 = new Alumne("Harry Potter", 1, Casa.Gryffindor);
		object2 = new MonthsList();
		object3 = new Restaurant("La Fonatana", 10);
		object4 = new Alumne("Draco Malfoy", 1, Casa.Slytherin);
		
		arrayList.add(object1);
		arrayList.add(object2);
		arrayList.add(object3);
		arrayList.add(object4);
    }
	
	@DisplayName("L'ordre de l'ArrayList és l'ordre de inserció d'aquests.")
	@Test
	void ensureArrayListOrderAsInserted() {		
		assertThat(arrayList)
			.as("L'ordre de l'ArrayList no és l'ordre d'inserció.")
			.containsExactly(object1, object2, object3, object4);
	}
	
	@DisplayName("L'ArrayList conté els mateixos elements pero en un altre ordre.")
	@Test
	void ensureArrayListElementsInAnyOrder() {
		arrayList = new ArrayList<Object>();
		arrayList.add(object4);
		arrayList.add(object3);
		arrayList.add(object2);
		arrayList.add(object1);		
		
		assertThat(arrayList)
			.as("L'ArrayList no conté els mateixos objectes.")
			.containsExactlyInAnyOrder(object1, object2, object3, object4);
	}
	
	@DisplayName("Un dels objectes només s'ha afegit una vegada.")
	@Test
	void ensureElementInAnyOrder() {
		assertThat(arrayList)
			.as("L'ArrayList conté l'objecte %s més d'una vegada.", object1)
			.containsOnlyOnce(object1);
	}
	
	@DisplayName("L'array no conté un dels objectes.")
	@Test
	void ensureAnElementIsNotInserted() {
		arrayList.remove(object1);		
		assertThat(arrayList)
			.as("L'ArrayList sí que conté l'objecte %s.", object1)
			.doesNotContain(object1);
	}
	
}
