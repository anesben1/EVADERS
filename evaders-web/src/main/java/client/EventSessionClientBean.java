package client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Event;
import entity.User;
import services.ServiceEventRemote;
import services.ServiceUser;

@ManagedBean
@SessionScoped
public class EventSessionClientBean {
	public static final int userID = 2;
	@EJB
	ServiceEventRemote serviceEvent;
	@EJB
	ServiceUser serviceUser;
	public String addError="";
	public String dateEvent="";
	public Event event = new Event();
	public Event eventEdit = new Event();

		
	Event currentEvent;
	String search = "";
	
	public String goDetails(Event event){
		currentEvent = event;
		return "details.jsf?faces-redirect=true";
	}
	
	public String goDetailsById(int id){
		
		currentEvent = serviceEvent.find(id);
		return "details.jsf?faces-redirect=true";
	}
	
	public Event getCurrentEvent() {
		return currentEvent;
	}
	
	
	public String setCurrentEvent(Event e){
		serviceEvent.setStatusEvent(e.getId());
		return "list.jsf?faces-redirect=true";
	}
	
	public String doSubscibe() {
		if(isSubscribed())
			serviceEvent.unSubscribeEvent(currentEvent.getId(), userID);
		else
			serviceEvent.subscribeEvent(currentEvent.getId(), userID);

		return "detail.jsf";
	}
	public String doTest() {
		System.out.println(" ************************************* ");
		for(Event e : serviceEvent.getBestEvents()) {
			System.out.println(e.getName());
		}
		return "home.jsf";
	}
	
	public String addEvent(){
		User u = serviceUser.ReturnUserbyId(userID);
		
	   SimpleDateFormat formatter4=new SimpleDateFormat("EEEE MMM dd yyyy");  
	    Date date = new Date();
		try {
			date = formatter4.parse(dateEvent);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
		    addError = "Date invalide";
			date = new Date();
		    return "add.jsf?faces-redirect=true";

		} 
	    
		event.setDate(date);
		event.setOwner(u);
		event.setEnabled(false);
		if(date.before(new Date())) {
		   addError = "Date ulétrieure";
		   return "add.jsf?faces-redirect=true";

		}
		serviceEvent.add(event);
		event = new Event();
		addError="";
		return "home.jsf?faces-redirect=true";
	}
	
	public String doEdit(Event event) {
		eventEdit = event;
		return "edit.jsf?faces-redirect=true";

	}
	
	public String editEvent(){
		User u = serviceUser.ReturnUserbyId(userID);
		
	   SimpleDateFormat formatter4=new SimpleDateFormat("EEEE MMM dd yyyy");  
	    Date date = new Date();
		try {
			date = formatter4.parse(dateEvent);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
		    addError = "Date invalide";
			date = new Date();
		    return "add.jsf?faces-redirect=true";

		} 
	    
		eventEdit.setDate(date);
		eventEdit.setOwner(u);
		if(date.before(new Date())) {
		   addError = "Date ulétrieure";
		   return "edit.jsf?faces-redirect=true";

		}
		serviceEvent.update(eventEdit);
		eventEdit = new Event();
		addError="";
		return "home.jsf?faces-redirect=true";
	}
	
	
	
	

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getAddError() {
		return addError;
	}

	public void setAddError(String addError) {
		this.addError = addError;
	}

	public List<Event> getSearchEvent(){
		if(search.length()>0)
		return serviceEvent.getAllEventsByName(search);
		return serviceEvent.getAvailableEvents();
	}
	
	public String doSearch() {
		
		return "search.jsf?faces-redirect=true";
	}
	
	public String subscribeActionLabel() {
		if(isSubscribed())
			return "Désabonnez";
		else
			return "Abonnez";
	}
	
	

	public boolean isSubscribed() {
		boolean resutlt = false;
		for(Event e :serviceEvent.getAllEventsByUser(userID) ) {
			if(e.getId()==currentEvent.getId()) {
				resutlt = true;
				break;
			}
		}
		return resutlt;
	}

	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Event getEventEdit() {
		return eventEdit;
	}

	public void setEventEdit(Event eventEdit) {
		this.eventEdit = eventEdit;
	}
	
	
	
	
	
	
}
