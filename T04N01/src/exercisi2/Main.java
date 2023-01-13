package exercisi2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CalculoDni calculoDni = new CalculoDni();
		for(Integer dni:CalculoDni.getName())
		{
			System.out.println(dni + " " + CalculoDni.calculateLetter(dni));
		}
	}

}
