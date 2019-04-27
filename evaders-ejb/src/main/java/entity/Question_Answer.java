package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question_Answer
 *
 */
@Entity

public class Question_Answer implements Serializable {

	   
	@Id
	private int id;
	private String question_answer;
	private int isCorrect;
	private static final long serialVersionUID = 1L;
    @ManyToOne
    private Question questions;
	public Question getQuestions() {
		return questions;
	}
	public void setQuestions(Question questions) {
		this.questions = questions;
	}
	public Question_Answer() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getQuestion_answer() {
		return this.question_answer;
	}

	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}   
	public int getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(int isCorrect) {
		this.isCorrect = isCorrect;
	}
   
}
