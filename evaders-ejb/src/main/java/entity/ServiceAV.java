package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceAV implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSAV;
	
	private int idUser;

	private Date dateSAV;

	@Enumerated(EnumType.STRING)
	private CategorieAV categorieAV;

	private String sujet;

	private boolean etat;

	private boolean treated;
	
	public int getIdSAV() {
		return idSAV;
	}

	public void setIdSAV(int idSAV) {
		this.idSAV = idSAV;
	}

	public Date getDateSAV() {
		return dateSAV;
	}

	public void setDateSAV(Date dateSAV) {
		this.dateSAV = dateSAV;
	}

	public CategorieAV getCategorieAV() {
		return categorieAV;
	}

	public void setCategorieAV(CategorieAV categorieAV) {
		this.categorieAV = categorieAV;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ServiceAV() {
	}

	@Override
	public String toString() {
		return "ServiceAV [idSAV=" + idSAV + ", dateSAV=" + dateSAV + ", categorieAV=" + categorieAV + ", sujet="
				+ sujet + ", etat=" + etat + "]";
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
	

}
