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
public class Reclamation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRec;
		
	private Date dateRec;
	
	@Enumerated(EnumType.STRING)
	private CategorieRec categorieRec;
	
	private String sujet;
	
	private boolean etat;
	
	private int iduser;
	
	private boolean treated;
	
	public int getIdRec() {
		return idRec;
	}
	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}
	
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	
	
	public Date getDateRec() {
		return dateRec;
	}
	public void setDateRec(Date dateRec) {
		this.dateRec = dateRec;
	}
	public CategorieRec getCategorieRec() {
		return categorieRec;
	}
	public void setCategorieRec(CategorieRec categorieRec) {
		this.categorieRec = categorieRec;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}
	

	public Reclamation() {
	}
	@Override
	public String toString() {
		return "Reclamation [idRec=" + idRec + ", idUser=" + iduser + ", dateRec=" + dateRec + ", categorieRec="
				+ categorieRec + ", sujet=" + sujet + ", etat=" + etat + ", iduser=" + iduser + ", treated=" + treated
				+ "]";
	}


	
	
	

}
