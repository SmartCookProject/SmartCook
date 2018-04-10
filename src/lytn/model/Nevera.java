package lytn.model;

import java.util.List;

public class Nevera {
	
	private int codigo;
	private String nombre;
	private Usuari usuari;
	private List<Ingredient> ingredients;
	
	public Nevera() {}
	
	public Nevera(int codigo, String nombre, Usuari usuari, List<Ingredient> ingredients) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.usuari = usuari;
		this.ingredients = ingredients;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Nevera [codigo=" + codigo + ", nombre=" + nombre + ", usuari=" + usuari + ", ingredients=" + ingredients
				+ "]";
	}
}
