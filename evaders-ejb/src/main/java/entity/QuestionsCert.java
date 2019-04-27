package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: QuestionsCert
 *
 */
@Entity

public class QuestionsCert implements Serializable {
	

	   
	@Id
	private int id;
	private String questions;
	private String OptionA;
	private String OptionB;
	private String OptionC;
	private int correctOption;
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Quizcertif quizcertifs;
	
	public Quizcertif getQuizcertifs() {
		return quizcertifs;
	}
	public void setQuizcertifs(Quizcertif quizcertifs) {
		this.quizcertifs = quizcertifs;
	}
	
	public QuestionsCert() {
		super();
	}   
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getOptionA() {
		return OptionA;
	}
	public void setOptionA(String optionA) {
		OptionA = optionA;
	}
	public String getOptionB() {
		return OptionB;
	}
	public void setOptionB(String optionB) {
		OptionB = optionB;
	}
	public String getOptionC() {
		return OptionC;
	}
	public void setOptionC(String optionC) {
		OptionC = optionC;
	}
	public int getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}
   
}
