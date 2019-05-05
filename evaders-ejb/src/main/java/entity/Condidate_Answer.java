package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Condidate_Answer
 *
 */
@Entity

public class Condidate_Answer implements Serializable {

	   
	@Id
	private int id;
	private String condidate_answer;
	@ManyToOne
	@JoinColumn(name="idQuestion", referencedColumnName="id",insertable=false ,updatable=false)
    private Question questionA;
	
	@ManyToOne
	@JoinColumn(name="idCondidateprofile", referencedColumnName="id",insertable=false ,updatable=false)
    private Condidate_Profile CondidateP;
	
	public Condidate_Profile getCondidateP() {
		return CondidateP;
	}
	public void setCondidateP(Condidate_Profile condidateP) {
		CondidateP = condidateP;
	}
	public Question getQuestionA() {
		return questionA;
	}
	public void setQuestionA(Question questionA) {
		this.questionA = questionA;
	}

	private static final long serialVersionUID = 1L;

	
	
	
	public Condidate_Answer() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCondidate_answer() {
		return condidate_answer;
	}
	public void setCondidate_answer(String condidate_answer) {
		this.condidate_answer = condidate_answer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Condidate_Answer(int id, String condidate_answer, Question questionA, Condidate_Profile condidateP) {
		super();
		this.id = id;
		this.condidate_answer = condidate_answer;
		this.questionA = questionA;
		CondidateP = condidateP;
	}
	
   
}
