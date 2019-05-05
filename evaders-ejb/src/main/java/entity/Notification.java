package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.sql.*;


/**
 * Entity implementation class for Entity: Notification
 *
 */
@Entity

public class Notification implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String type;
	private String content;
	private String link;
	private int isChecked;
	private Timestamp date;
	private static final long serialVersionUID = 1L;
    @ManyToOne
    private User user;
	
	
	public Notification() {
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
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}   
	public int getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
   
}
