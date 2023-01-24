package exercisi3;

public class Main {

	public static void main(String[] args) {
		OperacioInterface suma = (i1, i2) -> i1+i2;
		OperacioInterface resta = (i1, i2) -> i1-i2;
		OperacioInterface multiplicacio = (i1, i2) -> i1*i2;
		OperacioInterface divisio = (i1, i2) -> i1/i2;
		
		System.out.print("Suma: ");
		System.out.print(suma.operacio(15, 15));
		System.out.println();
		System.out.print("Resta: ");
		System.out.print(resta.operacio(15, 15));
		System.out.println();
		System.out.print("Multiplicació: ");
		System.out.print(multiplicacio.operacio(15, 15));
		System.out.println();
		System.out.print("Divisió: ");
		System.out.print(divisio.operacio(15, 15));
	}

}
