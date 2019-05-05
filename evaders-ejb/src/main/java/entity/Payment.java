package entity;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Payment
 *
 */
@Entity

public class Payment implements Serializable {

	   
	@Id
	private int id;
	private String type;
	private String duration;
	private int free_trial;
	private Timestamp date_debut;
	private static final long serialVersionUID = 1L;
	@OneToOne(mappedBy="payment")
	private Entreprise_Profile Entreprise;
	
	public Payment() {
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
	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}   
	public int getFree_trial() {
		return this.free_trial;
	}

	public void setFree_trial(int free_trial) {
		this.free_trial = free_trial;
	}   
	public Timestamp getDate_debut() {
		return this.date_debut;
	}

	public void setDate_debut(Timestamp date_debut) {
		this.date_debut = date_debut;
	}
   
}
