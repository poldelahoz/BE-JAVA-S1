package exercisi1;

public class Main {

	public static void main(String[] args) {
		try {
			Alumne alumne = new Alumne("Harry", "Potter", 1, Alumne.Casa.Gryffindor);
			ObjectToJsonConverter otjc = new ObjectToJsonConverter();
			otjc.convertToJson(alumne);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
