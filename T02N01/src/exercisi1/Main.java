package exercisi1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Venda venda;
	private static ArrayList<Producte> llistaProductesDemo;
	private static final DecimalFormat df = new DecimalFormat("0.00€");

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Introdueix el nombre de productes de test a crear per a la venda:");
			int nProductes = in.nextInt();
			in.close();
			crearLListaProductesDemo(nProductes);
			venda = new Venda(llistaProductesDemo);
			venda.calcularTotal();
			System.out.println("Preu total de la venda: " + df.format(venda.getPreuTotalVenda()));
		}catch(VendaBuidaException e) {
			System.err.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
		}
	}
	
	private static void crearLListaProductesDemo(int nProductes) {
		llistaProductesDemo = new ArrayList<Producte>(nProductes);
		for (int i = 0; i < nProductes; i++) {
			llistaProductesDemo.add(new Producte("Producte " + i+1, Double.valueOf(i+1)));
		}
	}
}
