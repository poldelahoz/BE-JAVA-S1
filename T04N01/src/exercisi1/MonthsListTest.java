package exercisi1;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MonthsListTest {
	
	@Test
	@DisplayName("List size = 12")
	void checkListSize() {
		MonthsList monthsList = new MonthsList();
		assertEquals(12, monthsList.getMonthsList().size(), "List size should be 12");
	}
	
	@Test
	@DisplayName("List != null")
	void checkNotNullList() {
		MonthsList monthsList = new MonthsList();
		assertNotNull("List size should be 12", monthsList);
	}
	
	@Test
	@DisplayName("List[7] = 'Agost'")
	void checkPositionList() {
		MonthsList monthsList = new MonthsList();
		assertEquals("Agost", monthsList.getMonthsList().get(7), "8th position should be 'Agost'");
	}

}
