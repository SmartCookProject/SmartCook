package lytn.model;

public class Ingredient {
	
	private int codigo;
	private String nom;
	private TipoIngrediente tipoIngrediente;
	private Nevera nevera;
	
	public Ingredient() {}
	
	public Ingredient(int codigo, String nom, TipoIngrediente tipoIngrediente, Nevera nevera) {
		this.codigo = codigo;
		this.nom = nom;
		this.tipoIngrediente = tipoIngrediente;
		this.nevera = nevera;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TipoIngrediente getTipoIngrediente() {
		return tipoIngrediente;
	}

	public void setTipoIngrediente(TipoIngrediente tipoIngrediente) {
		this.tipoIngrediente = tipoIngrediente;
	}

	public Nevera getNevera() {
		return nevera;
	}

	public void setNevera(Nevera nevera) {
		this.nevera = nevera;
	}

	@Override
	public String toString() {
		return "Ingredient [codigo=" + codigo + ", nom=" + nom + ", tipoIngrediente=" + tipoIngrediente + ", nevera="
				+ nevera + "]";
	}
}
