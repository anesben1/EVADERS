package entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Follow
 *
 */
@Entity

public class Follow implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Timestamp date;
	@ManyToOne
    @JoinColumn(name="idprofileentreprise", referencedColumnName="id",insertable=false ,updatable=false)
    private Entreprise_Profile profileEntreprise;
	@ManyToOne
    @JoinColumn(name="idprofilecondidat", referencedColumnName="id",insertable=false ,updatable=false)
    private Condidate_Profile profileCondidat;

	public Condidate_Profile getProfileCondidat() {
		return profileCondidat;
	}
	public void setProfileCondidat(Condidate_Profile profileCondidat) {
		this.profileCondidat = profileCondidat;
	}
	public Entreprise_Profile getProfileEntreprise() {
		return profileEntreprise;
	}
	public void setProfileEntreprise(Entreprise_Profile profileEntreprise) {
		this.profileEntreprise = profileEntreprise;
	}

	private static final long serialVersionUID = 1L;

	public Follow() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
   
}
