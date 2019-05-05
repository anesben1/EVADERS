package entity;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import entity.*;

/**
 * Entity implementation class for Entity: Condidate_Profile
 *
 */
@Entity

public class Condidate_Profile implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String img_url;
	private String intro;
	private String summary;
	private String current_state;
	private int age;
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private User  userCondidate;
	
	public User getUserCondidate() {
		return userCondidate;
	}

	public void setUserCondidate(User userCondidate) {
		this.userCondidate = userCondidate;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "profileCondidat", cascade = CascadeType.ALL)
	private List<Follow> follows= new ArrayList<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "CondidateConnected", cascade = CascadeType.ALL)
	private Set<Connection> Connections = new HashSet<>();
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ConnectedtoCondidate", cascade = CascadeType.ALL)
	private Set<Connection> ConnectionsInvitations = new HashSet<>();
	
	@OneToMany(mappedBy="condidate")
	private List<Experience> experiences = new ArrayList<>(); 
	
	@OneToOne(mappedBy="condidat")
	private Recrutement recrutement;
	@OneToMany(mappedBy="candidate")
	private List<Skill> skills;
	
	public Recrutement getRecrutement() {
		return recrutement;
	}

	public void setRecrutement(Recrutement recrutement) {
		this.recrutement = recrutement;
	}



	

	public Set<Connection> getConnections(){
		return Connections;
		 
	 
	
	}

	@OneToMany (mappedBy="Condidate_Profile")
	private List<Certification> certificat;
	
	public List<Certification> getCertificat() {
		return certificat;
	}
	
	public void setCertificat(List<Certification> certificat) {
		this.certificat = certificat;
	}
	
	@ManyToMany(mappedBy="Condidates")
	private List<Quizcertif>Quizcertifs;
	public List<Quizcertif> getQuizcertifs() {
		return Quizcertifs;
	}

	public void setQuizcertifs(List<Quizcertif> quizcertifs) {
		Quizcertifs = quizcertifs;
	}


	


	public void setConnections(Set<Connection> connections) {
		Connections = connections;
	}

	public Set<Connection> getConnectionsInvitations() {
		return ConnectionsInvitations;
	}

	public void setConnectionsInvitations(Set<Connection> connectionsInvitations) {
		ConnectionsInvitations = connectionsInvitations;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	@OneToMany(mappedBy="condidat")
	private List<Result> resultats;
	
	@OneToMany(mappedBy="condidatinterview")
	private List<Interview> entretiens;
	
	@OneToMany(mappedBy="CondidateP")
	private List<Condidate_Answer> CondidateAnswer ;
	
	@OneToMany(mappedBy="CondidateP")  
	private List<claim> claimC;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public int addExperience(Experience e){
		e.setCondidate(this);
		this.experiences.add(e);
		return id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCurrent_state() {
		return current_state;
	}

	public void setCurrent_state(String current_state) {
		this.current_state = current_state;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}

	public List<Result> getResultats() {
		return resultats;
	}

	public void setResultats(List<Result> resultats) {
		this.resultats = resultats;
	}

	public List<Interview> getEntretiens() {
		return entretiens;
	}

	public void setEntretiens(List<Interview> entretiens) {
		this.entretiens = entretiens;
	}

	public List<Condidate_Answer> getCondidateAnswer() {
		return CondidateAnswer;
	}

	public void setCondidateAnswer(List<Condidate_Answer> condidateAnswer) {
		CondidateAnswer = condidateAnswer;
	}

	public List<claim> getClaimC() {
		return claimC;
	}

	public void setClaimC(List<claim> claimC) {
		this.claimC = claimC;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public  Condidate_Profile()
	{
      Connections = new HashSet<>();
      follows = new ArrayList<Follow>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condidate_Profile other = (Condidate_Profile) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
   
}
