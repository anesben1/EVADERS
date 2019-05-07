package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pack implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPack;
	
	private String nom;
	
	private int nbre_offres;
	
	private int idUser;
	
	private float prix;
	
	private boolean etat;

	public int getIdPack() {
		return idPack;
	}

	public void setIdPack(int idPack) {
		this.idPack = idPack;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbre_offres() {
		return nbre_offres;
	}

	public void setNbre_offres(int nbre_offres) {
		this.nbre_offres = nbre_offres;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Pack() {
	}

	@Override
	public String toString() {
		return "Pack [idPack=" + idPack + ", nom=" + nom + ", nbre_offres=" + nbre_offres + ", prix=" + prix + ", etat="
				+ etat + "]";
	}


}
