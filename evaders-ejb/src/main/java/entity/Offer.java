package entity;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Offer
 *
 */
@Entity

public class Offer implements Serializable {

	   
	@Id
	private int id;
	private String speciality;
	private String description;
	private Timestamp date;
	private int vues;
	private int validation=0;
	@ManyToOne 
	private Entreprise_Profile entreprise;
	@OneToMany(mappedBy="offers")
    private List<Application> applications;
	@ManyToOne 
	private Quiz quiz;
	@OneToMany(mappedBy="offer")
    private List<Result> resultoffers;
	
	public List<Result> getResultoffers() {
		return resultoffers;
	}
	public void setResultoffers(List<Result> resultoffers) {
		this.resultoffers = resultoffers;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	public Entreprise_Profile getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise_Profile entreprise) {
		this.entreprise = entreprise;
	}

	private static final long serialVersionUID = 1L;

	public Offer() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getVues() {
		return vues;
	}
	public void setVues(int vues) {
		this.vues = vues;
	}
	public int getValidation() {
		return validation;
	}
	public void setValidation(int validation) {
		this.validation = validation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
