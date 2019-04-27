package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Experience
 *
 */
@Entity

public class Experience implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String content;
	private int rate;
	@ManyToOne
	private Condidate_Profile condidate ;
	
	private static final long serialVersionUID = 1L;

	public Experience() {
		super();
	}   
	public Condidate_Profile getCondidate() {
		return condidate;
	}
	public void setCondidate(Condidate_Profile condidate) {
		this.condidate = condidate;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
   
}
