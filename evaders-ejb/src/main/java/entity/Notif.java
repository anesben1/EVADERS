package entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Notification
 *
 */
@Entity

public class Notif implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
	private int isChecked;
	private Date date;
	private static final long serialVersionUID = 1L;
    private int idUser;
    private String type;
	
	public Notif() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   

	public int getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
   
}
