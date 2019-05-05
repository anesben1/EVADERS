package entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Application
 *
 */
@Entity

public class Application implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date date;
	private int isAccepted;
	private static final long serialVersionUID = 1L;
	 @ManyToOne
	    @JoinColumn(name="idUser", referencedColumnName="id",insertable=false ,updatable=false)
	    private User userapplies;
	 public User getUserapplies() {
		return userapplies;
	}
	public void setUserapplies(User userapplies) {
		this.userapplies = userapplies;
	}

	@ManyToOne
	    @JoinColumn(name="idoffer", referencedColumnName="id",insertable=false ,updatable=false)
	    private Offer offers;
	public Offer getOffers() {
		return offers;
	}
	public void setOffers(Offer offers) {
		this.offers = offers;
	}
	public Application() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   

	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIsAccepted() {
		return this.isAccepted;
	}

	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}
   
}
