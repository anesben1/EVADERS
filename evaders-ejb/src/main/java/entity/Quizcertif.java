package entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Quizcertif
 *
 */
@Entity

public class Quizcertif implements Serializable {

	   
	@Id
	private int id_quiz;
	private String speciality ; 
	private static final long serialVersionUID = 1L;
	@OneToMany (mappedBy="quizcertifs")
	private List<QuestionsCert> questions;

	
	
	
	public void setQuestions(List<QuestionsCert> questions) {
		this.questions = questions;
	}
	public List<QuestionsCert> getQuestions() {
		return questions;
	}
	public int getId_quiz() {
		return this.id_quiz;
	}

	public void setId_quiz(int id_quiz) {
		this.id_quiz = id_quiz;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@ManyToMany
	private List<Condidate_Profile> Condidates;

	public List<Condidate_Profile> getCondidates() {
	return Condidates;
	}	
	public void setCondidates(List<Condidate_Profile> condidates) {
	Condidates = condidates;
	}

	
	
	
	
   
}
