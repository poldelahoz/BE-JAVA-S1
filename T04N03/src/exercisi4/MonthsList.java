package exercisi4;

import java.util.ArrayList;

public class MonthsList {
	
	private final ArrayList<String> monthsList;
	
	public MonthsList() {
		monthsList = new ArrayList<String>();
		monthsList.add("Gener");
		monthsList.add("Febrer");
		monthsList.add("Març");
		monthsList.add("Abril");
		monthsList.add("maig");
		monthsList.add("Juny");
		monthsList.add("Juliol");
		monthsList.add("Agost");
		monthsList.add("Setembre");
		monthsList.add("Octubre");
		monthsList.add("Novembre");
		monthsList.add("Desembre");
	}
	
	public ArrayList<String> getMonthsList() {
		return monthsList;
	}
}
