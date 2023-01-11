package exercisi1;

import java.util.ArrayList;

public class Venda {
	
	private static ArrayList<Producte> Productes; 
	
	private Double preuTotalVenda;
	
	public Venda(ArrayList<Producte> Productes){
		Venda.Productes = Productes;
	}
	
	public Double getPreuTotalVenda() {
		return preuTotalVenda;
	}

	public void calcularTotal() throws VendaBuidaException {
		
		if (Venda.Productes.isEmpty())
		{
			throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
		}else {
			preuTotalVenda = 0.0;
			for(Producte producte:Venda.Productes){
				preuTotalVenda += producte.getPreu();
			}
		}
	}
}
