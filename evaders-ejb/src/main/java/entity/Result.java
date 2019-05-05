package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Result
 *
 */
@Entity

public class Result implements Serializable {

	   
	@Id
	private int id;
	private int result;
	private int isAccepted;
	private static final long serialVersionUID = 1L;
	@ManyToOne
    @JoinColumn(name="idoffer", referencedColumnName="id",insertable=false ,updatable=false)
    private Offer offer;
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@ManyToOne
    @JoinColumn(name="idcondidat", referencedColumnName="id",insertable=false ,updatable=false)
    private Condidate_Profile condidat;
	public Condidate_Profile getCondidat() {
		return condidat;
	}
	public void setCondidat(Condidate_Profile condidat) {
		this.condidat = condidat;
	}
	public Result() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getResult() {
		return this.result;
	}

	public void setResult(int result) {
		this.result = result;
	}   
	public int getIsAccepted() {
		return this.isAccepted;
	}

	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}
   
}
