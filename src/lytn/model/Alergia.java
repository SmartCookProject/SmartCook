package lytn.model;

public class Alergia {
	
	private int id;
	private String nom;
	
	public Alergia() {}
	
	public Alergia(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Alergia [id=" + id + ", nom=" + nom + "]";
	}
}
