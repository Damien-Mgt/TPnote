import java.util.List;

public class Administrateur extends Employe {

	public Administrateur(Agence a, Entreprise e) {
		super(a, e);
	}
	
	public boolean attribuerMateriel(Empruntable e_ble, Emprunteur e_eur) {
		if(e_eur instanceof Agence) {
			if(this.perdreMateriel(e_ble)) {
				e_eur.ajouterAuStock(e_ble);
				return true;
			}
			else
				return false;
		}
		else {
			if(e_ble.isLimitationPretAuxAgences()) {
				return false;
			}
			else {
				if(this.perdreMateriel(e_ble)) {
					e_eur.ajouterAuStock(e_ble);
					return true;
				}
				else
					return false;
			}
		}
	}
	
	public boolean recupererMateriel(Empruntable e_ble, Emprunteur e_eur) {
		if(e_eur.perdreMateriel(e_ble)) {
			this.ajouterAuStock(e_ble);
			return true;
		}
		else
			return false;
	}
	
	public List<Empruntable> stockEntreprise() {
		return this.getEntreprise().listeMateriel();
	}
	
	public List<Empruntable> stockAgence() {
		return this.getAgence().listeMateriel();
	}
	
	public void transfererMateriel(Emprunteur e_eur1, Empruntable e_ble, Emprunteur e_eur2) {
		if(e_ble.isLimitationPretAuxAgences()) {
			if(e_eur2.getClass() == Agence.class) {
				if(e_eur1.perdreMateriel(e_ble))
					e_eur2.ajouterAuStock(e_ble);
			}
		}
		else {
			if(e_eur1.perdreMateriel(e_ble))
				e_eur2.ajouterAuStock(e_ble);
		}
	}
	
	public void supprimerMateriel(Empruntable e_able) {
		this.perdreMateriel(e_able);
	}

	public void supprimerMaterielDefectueuxEntreprise() {
		//dans le stock de l'entreprise
		for(Empruntable e_ble : this.getEntreprise().listeMateriel()){
			if(e_ble.isDefectueux())
				this.getEntreprise().perdreMateriel(e_ble);
		}
		//dans le stock des agences
		for(Agence a : this.getEntreprise().getAgences())
			supprimerMaterielDefectueuxAgence(a);
	}
				
	public void supprimerMaterielDefectueuxAgence(Agence a) {
		//dans le stock de l'agence
		for(Empruntable e_ble : a.listeMateriel()){
			if(e_ble.isDefectueux())
				a.perdreMateriel(e_ble);
		}	
		//dans le stock des employes
		for(Employe e : a.getEmployes())
			supprimerMaterielDefectueuxDe(e);
	}
	
	private void supprimerMaterielDefectueuxDe(Emprunteur e_eur) {
		for(Empruntable e_ble : e_eur.listeMateriel()){
			if(e_ble.isDefectueux())
				e_eur.perdreMateriel(e_ble);
		}	
	}
}
