package entity;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Quiz
 *
 */
@Entity

public class Quiz implements Serializable {

	   
	@Id
	private int id;
	private String domain;
	private String diffculty;
	private Timestamp date;
	private static final long serialVersionUID = 1L;
	@ManyToOne
    private Entreprise_Profile quizEntreprise;
	@OneToMany(mappedBy="quiz")
	private List<Offer> listeOffers;
	@OneToMany(mappedBy="quizquestion")
	private List<Question> listQuestion;
	
	
	public List<Question> getListQuestion() {
		return listQuestion;
	}
	public void setListQuestion(List<Question> listQuestion) {
		this.listQuestion = listQuestion;
	}
	public List<Offer> getListeOffers() {
		return listeOffers;
	}
	public void setListeOffers(List<Offer> listeOffers) {
		this.listeOffers = listeOffers;
	}
	public Entreprise_Profile getQuizEntreprise() {
		return quizEntreprise;
	}
	public void setQuizEntreprise(Entreprise_Profile quizEntreprise) {
		this.quizEntreprise = quizEntreprise;
	}
	public Quiz() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}   
	public String getDiffculty() {
		return this.diffculty;
	}

	public void setDiffculty(String diffculty) {
		this.diffculty = diffculty;
	}   
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
   
}
