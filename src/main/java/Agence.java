import java.util.ArrayList;
import java.util.List;

public class Agence extends Emprunteur {

	private List<Employe> employes;
	private String nom;
	
	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Agence(String n) {
		super();
		employes = new ArrayList<Employe>();
		this.nom = n;
	}
	
}
