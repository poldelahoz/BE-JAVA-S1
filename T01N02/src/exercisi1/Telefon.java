package exercisi1;

public class Telefon {
	private String marca;
	private String model;
	
	public Telefon(String marca, String model) {
		this.setMarca(marca);
		this.setModel(model);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public void trucar(String numero) {
		System.out.println("S'està trucant al " + numero);
	}
}
