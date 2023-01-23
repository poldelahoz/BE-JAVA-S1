package Exercisi1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

public class MatcherPersonalitzat {
	
	@Test
	public void comprovaMordorTe8() {
	    assertThat("Mordor", match(is(8)));
	}
	
	public static  Matcher<String> match(Matcher<? super Integer> matcher) {
	    return new FeatureMatcher<String, Integer>(matcher, "Té una longitud de 8", "No té una longitud de 8") {
	        @Override
	        protected Integer featureValueOf(String actual) {
	        	return actual.length();
	        }
	    };
	}
	
}
