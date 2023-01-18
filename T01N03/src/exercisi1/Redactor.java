package exercisi1;

import java.util.List;

public class Redactor{
	
	private String nom;
	private final String DNI;
	private List<Noticia> noticies;
	
	public Redactor(String nom, String DNI) {
		this.setNom(nom);
		this.DNI = DNI;
	}
	
	public List<Noticia> getNoticies() {
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
        return noticies.stream().filter(n -> titular.equals(n.getTitular())).findAny().orElse(null);
	}
	
	/**
	 * @param noticia the noticia to add to noticies
	 */
	public boolean afegirNoticia(Noticia noticia) {
		try {
			noticies.add(noticia);
			return true;
		}catch(Exception e){
			System.out.println("No s'ha pogut afegir la notícia: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * @param noticia the noticia to remove from noticies
	 */
	public void borrarNoticia(Noticia noticia) {
		noticies.remove(noticia);
	}
}
