package entity;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Skill
 *
 */
@Entity

public class Skill implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String content;
	private String speciality ;
	private int rate;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Condidate_Profile candidate;

	public Skill() {
		super();
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
	public Condidate_Profile getCandidate() {
		return candidate;
	}
	public void setCandidate(Condidate_Profile candidate) {
		this.candidate = candidate;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", content=" + content + ", speciality=" + speciality + ", rate=" + rate
				+ ", candidate=" + candidate + "]";
	}
	/*List<Skill> list = new ArrayList<Skill>();

	public List<Skill> getList() {
		return list;
	}
	public void setList(List<Skill> list) {
		this.list = list;
	}*/
	
   
}
