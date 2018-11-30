
public class Empruntable {

	private boolean limitationPretAuxAgence;
	private boolean defectueux;
	
	public Empruntable() {
		this.limitationPretAuxAgence = false;
		this.defectueux = false;
	}
	
	public Empruntable(boolean b) {
		this.limitationPretAuxAgence = b;
		this.defectueux = false;
	}
	     
	public void declarerDefectueux() {
		this.defectueux = true;
	}
	
	public boolean isDefectueux() {
		return this.defectueux;
	}
	
	public boolean isLimitationPretAuxAgences() {
		return this.limitationPretAuxAgence;
	}
	
	public void setLimitationPretAuxAgence(boolean l) {
		this.limitationPretAuxAgence = l;
	}
}
