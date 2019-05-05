package entity;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Interview
 *
 */
@Entity

public class Interview implements Serializable {

	   
	@Id
	private int id;
	private Timestamp date;
	private String title;
	private String description;
	private Timestamp creation_date;
	private static final long serialVersionUID = 1L;
	@ManyToOne
    @JoinColumn(name="idcondidat", referencedColumnName="id",insertable=false ,updatable=false)
    private Condidate_Profile condidatinterview;
	public Condidate_Profile getCondidatinterview() {
		return condidatinterview;
	}
	public void setCondidatinterview(Condidate_Profile condidatinterview) {
		this.condidatinterview = condidatinterview;
	}

	@ManyToOne
    @JoinColumn(name="identreprise", referencedColumnName="id",insertable=false ,updatable=false)
    private Condidate_Profile entrepriseinterview;
	public Condidate_Profile getEntrepriseinterview() {
		return entrepriseinterview;
	}
	public void setEntrepriseinterview(Condidate_Profile entrepriseinterview) {
		this.entrepriseinterview = entrepriseinterview;
	}
	public Interview() {
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
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Timestamp getCreation_date() {
		return this.creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}
   
}
