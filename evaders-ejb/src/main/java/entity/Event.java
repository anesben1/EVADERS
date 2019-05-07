package entity;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Event implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private boolean enabled;
	private int places;
	private String description;
	private String address;
	private Date createdDate = new Date();
	private Date date;
	
	@OneToOne()
	private User owner;
	
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name = "event_user",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> users = new ArrayList<>() ;
    
	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}   
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPlaces() {
		return places;
	}


	public void setPlaces(int places) {
		this.places = places;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}




	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}   
	
	public void addUser(User user) {
        users.add(user);
        user.getEvents().add(this);
    }
 
    public void removeUser(User user) {
    	users.remove(user);
    	user.getEvents().remove(this);
    }


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	

   
}
