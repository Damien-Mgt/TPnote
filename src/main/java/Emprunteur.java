import java.util.ArrayList;
import java.util.List;

public class Emprunteur {

	private List<Empruntable> stock;
	
	public Emprunteur() {
		this.stock = new ArrayList<Empruntable>();
	}
	
	public Emprunteur(List<Empruntable> s) {
		this.stock = s;
	}

	public void setStock(List<Empruntable> stock) {
		this.stock = stock;
	}
	
	void ajouterAuStock(Empruntable e) {
		stock.add(e);
	}
	
	List<Empruntable> listeMateriel(){
		return this.stock;
	}
	
	boolean perdreMateriel(Empruntable e) {
		return this.stock.remove(e);
	}
	
}
