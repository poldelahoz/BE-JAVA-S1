package exercisi1;

import java.util.ArrayList;

public class Redactor{
	
	private String nom;
	private final String DNI;
	private ArrayList<Noticia> noticies = new ArrayList<Noticia>();
	
	public Redactor(String nom, String DNI) {
		this.setNom(nom);
		this.DNI = DNI;
	}
	
	public ArrayList<Noticia> getNoticies() {
		return noticies;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDNI() {
		return DNI;
	}
	
	/**
	 * @return the redactor with Dni/Nom in redactors or null
	 */
	public Noticia getNoticia(String titular) {
        return noticies.stream().filter(n -> titular.equals(n.getTitular())).findFirst().orElse(null);
	}
	
	/**
	 * @param noticia the noticia to add to noticies
	 */
	public boolean afegirNoticia(Noticia noticia) {
		try {
			noticies.add(noticia);
			System.out.println();
			System.out.println("Notícia afegida correctament.");
			return true;
		}catch(Exception e){
			System.err.println("No s'ha pogut afegir la notícia: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * @param noticia the noticia to remove from noticies
	 */
	public boolean borrarNoticia(String titular) {	
		return noticies.remove(noticies.stream().filter(n -> titular.equals(n.getTitular())).findFirst().orElse(null));
	}
}
