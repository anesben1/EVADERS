package entity;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: claim
 *
 */
@Entity

public class claim implements Serializable {

	   
	@Id
	private int id;
	private String type;
	private String content;
	private Timestamp date;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="idcondidateprofile", referencedColumnName="id",insertable=false ,updatable=false)
    private Condidate_Profile CondidateP;
	@ManyToOne
	@JoinColumn(name="identrepriseprofile", referencedColumnName="id",insertable=false ,updatable=false)
    private Entreprise_Profile EntrepriseProfile;
	
	
	public Entreprise_Profile getEntrepriseProfile() {
		return EntrepriseProfile;
	}
	public void setEntrepriseProfile(Entreprise_Profile entrepriseProfile) {
		EntrepriseProfile = entrepriseProfile;
	}
	public Condidate_Profile getCondidateP() {
		return CondidateP;
	}
	public void setCondidateP(Condidate_Profile condidateProfile) {
		CondidateP = condidateProfile;
	}
	public claim() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
   
}
