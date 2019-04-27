package entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Recrutement
 *
 */
@Entity

public class Recrutement implements Serializable {

	   
	@Id
	private int id;
	private Timestamp date_dembauche;
	private static final long serialVersionUID = 1L;
    @OneToOne
    private Condidate_Profile condidat;
    @ManyToOne
    private Entreprise_Profile entreprise;
	public Entreprise_Profile getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise_Profile entreprise) {
		this.entreprise = entreprise;
	}
	public Condidate_Profile getCondidat() {
		return condidat;
	}
	public void setCondidat(Condidate_Profile condidat) {
		this.condidat = condidat;
	}
	public Recrutement() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDate_dembauche() {
		return date_dembauche;
	}
	public void setDate_dembauche(Timestamp date_dembauche) {
		this.date_dembauche = date_dembauche;
	}   
	
	
   
}
