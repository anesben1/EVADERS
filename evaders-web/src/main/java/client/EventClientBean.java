package client;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import com.google.gson.Gson;

import Bean.SessionUtils;
import entity.Event;
import entity.User;
import services.ServiceEventRemote;
import services.ServiceUserRemote;

@ManagedBean
@RequestScoped
public class EventClientBean {
	
	public static int userId = 2;
	public int place;
	public String nom;
	public String adresse;
	public String description;
	public String dateEvent;
	public Event event = new Event();

	
	@EJB
	ServiceEventRemote serviceEvent;
	
	@EJB
	ServiceUserRemote serviceUser;
		

	public List<Event> getAvailableEvents(){
		return serviceEvent.getAvailableEvents();
	}
	
	public String getRandomImage() {
		int max = 4;
		double randomDouble = Math.random();
		randomDouble = randomDouble * max + 1;
		int randomInt = (int) randomDouble;
		return "event"+randomInt+".jpg";
	}
	
	public String getCalendarData() {
		JSONArray jArray = new JSONArray();
	    for (Event e : serviceEvent.getAvailableEvents())
	    {
	         JSONObject studentJSON = new JSONObject();
	         studentJSON.put("title", e.getName());
	         studentJSON.put("start", e.getDate().toString());
	         studentJSON.put("id", e.getId());
	         studentJSON.put("url", e.getPlaces());

	         jArray.put(studentJSON);
	    }
		System.out.println(jArray.toString());
		return jArray.toString();
	}
	
	
	public List<Event> getAvailablePlaceEvents(){
		return serviceEvent.getAvailablePlaceEvents();
	}
	
	public List<Event> getSubscribedEvents(){
		return serviceEvent.getAllEventsByUser(SessionUtils.getUser().getId());
	}	
	
	
	
	public String goToAvailablePlaceEvent(Event e){
		return "listAvailable.jsf?jsf-redirect=true";
	}
	
	public String getStatusAction(Event e) {
		if(e.isEnabled())
			return "Désactiver";
		return "Activer";
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		description = description;
	}

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	
	
}
