package entity;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Entreprise_Profile
 *
 */
@Entity

public class Entreprise_Profile implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=  GenerationType.IDENTITY)
	private int id;
	private String name;
	private String website;
	private String industry;
	private int size;
	private String address;
	private String headquarter;
	private String type;
	private Timestamp date_foundation;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="Entreprise")
	private List<User> listeEmployees;
	@OneToMany(mappedBy="profileEntreprise")
	private List<Follow> follows;
	@OneToMany(mappedBy="quizEntreprise")
	private List<Quiz> quizs;
	@OneToMany(mappedBy="entrepriseinterview")
	private List<Interview> entretiens;
	@OneToMany(mappedBy="EntrepriseProfile")  
	private List<claim> claimC;
	@OneToOne 
	private Payment payment;


	@OneToOne(mappedBy="Admin_deEntreprise")
	private User  user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy="entreprise")
	private List<Recrutement> recrutements;
	public List<Recrutement> getRecrutements() {
		return recrutements;
	}
	public void setRecrutements(List<Recrutement> recrutements) {
		this.recrutements = recrutements;
	}
	@OneToOne 
	private User Admin;
	
	public List<claim> getClaimC() {
		return claimC;
	}
	public void setClaimC(List<claim> claimC) {
		this.claimC = claimC;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public User getAdmin() {
		return Admin;
	}
	public void setAdmin(User admin) {
		Admin = admin;
	}
	public List<Interview> getEntretiens() {
		return entretiens;
	}
	public void setEntretiens(List<Interview> entretiens) {
		this.entretiens = entretiens;
	}
	public List<Quiz> getQuizs() {
		return quizs;
	}
	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}
	public List<Follow> getFollows() {
		return follows;
	}
	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}
	public List<User> getListeEmployees() {
		return listeEmployees;
	}
	public void setListeEmployees(List<User> listeEmployees) {
		this.listeEmployees = listeEmployees;
	}

	@OneToMany(mappedBy="entreprise")
	private List<Offer> listoffers;

	public List<Offer> getListoffers() {
		return listoffers;
	}
	public void setListoffers(List<Offer> listoffers) {
		this.listoffers = listoffers;
	}
	public Entreprise_Profile() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}   
	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}   
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}   
	public String getHeadquarter() {
		return this.headquarter;
	}

	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public Timestamp getDate_foundation() {
		return this.date_foundation;
	}

	public void setDate_foundation(Timestamp date_foundation) {
		this.date_foundation = date_foundation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
   
}
