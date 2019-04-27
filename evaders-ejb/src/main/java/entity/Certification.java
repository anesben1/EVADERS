package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Certification
 *
 */
@Entity

public class Certification implements Serializable {

	   
	@Id
	private int id;
	private String speciality ;

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Condidate_Profile Condidate_Profile;
	
	

	public Certification() {
		super();
	}   
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public Condidate_Profile getCondidate_Profile() {
		return Condidate_Profile;
	}
	public void setCondidate_Profile(Condidate_Profile condidate_Profile) {
		Condidate_Profile = condidate_Profile;
	}
}
