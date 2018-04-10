package lytn.model;

import java.util.List;

public class Usuari {
	
	private int id;
	private String nom;
	private String primerCognom;
	private String segonCognom;
	private String correu;
	private String foto;
	private List<Alergia> alergies;
	private Nevera nevera;
	
	public Usuari() {}
	
	public Usuari(int id, String nom, String primerCognom, String segonCognom, String correu, String foto, List<Alergia> alergies, Nevera nevera) {
		this.id = id;
		this.nom = nom;
		this.primerCognom = primerCognom;
		this.segonCognom = segonCognom;
		this.correu = correu;
		this.foto = foto;
		this.alergies = alergies;
		this.nevera = nevera;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrimerCognom() {
		return primerCognom;
	}

	public void setPrimerCognom(String primerCognom) {
		this.primerCognom = primerCognom;
	}

	public String getSegonCognom() {
		return segonCognom;
	}

	public void setSegonCognom(String segonCognom) {
		this.segonCognom = segonCognom;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Alergia> getAlergies() {
		return alergies;
	}

	public void setAlergies(List<Alergia> alergies) {
		this.alergies = alergies;
	}

	public Nevera getNevera() {
		return nevera;
	}

	public void setNevera(Nevera nevera) {
		this.nevera = nevera;
	}

	@Override
	public String toString() {
		return "Usuari [id=" + id + ", nom=" + nom + ", primerCognom=" + primerCognom + ", segonCognom=" + segonCognom
				+ ", correu=" + correu + ", foto=" + foto + ", alergies=" + alergies + ", nevera=" + nevera + "]";
	}
}
