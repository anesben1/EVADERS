package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Bean.SessionUtils;
import entity.Event;
import entity.User;
import services.ServiceEventRemote;
import services.ServiceUser;

@ManagedBean
@SessionScoped
public class EventSessionClientBean {
	public static final int userId = 2;
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
		if(!isSubscribed()){
			/*sendSms(
					"Wael Admin",
					"Merci "
					+SessionUtils.getUser().getFirst_name() 
					+" "+SessionUtils.getUser().getLast_name() 
					+" , pour votre abonnement à l'évènement "+
					currentEvent.getName(),
					"216"+SessionUtils.getUser().getPhone_number()
					);*/
			serviceEvent.subscribeEvent(currentEvent.getId(), SessionUtils.getUser().getId());
		}
		return "detail.jsf";
	}
	public String doTest() {
		for(Event e : serviceEvent.getBestEvents()) {
			System.out.println(e.getName());
		}
		return "home.jsf";
	}
	
	public String addEvent(){
		User u = serviceUser.ReturnUserbyId(SessionUtils.getUser().getId());
		
	    SimpleDateFormat formatter4=new SimpleDateFormat("EEEE MMM dd yyyy", Locale.ENGLISH);  
	    Date date = new Date();
	    System.out.println("eeeeee "+dateEvent);
		try {
			date = formatter4.parse(dateEvent);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
		    addError = "Date invalide";
			date = new Date();
		    return "add.jsf?faces-redirect=true";

		} 
		
		if(event.getPlaces()<=0){
			 addError = "place invalide";
		      return "add.jsf?faces-redirect=true";
		}
		if(event.getName().length()==0){
			 addError = "nom invalide";
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
		User u = serviceUser.ReturnUserbyId(SessionUtils.getUser().getId());
		
	    SimpleDateFormat formatter4=new SimpleDateFormat("EEEE MMM dd yyyy", Locale.ENGLISH);  
	    Date date = new Date();
		try {
			date = formatter4.parse(dateEvent);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
		    addError = "Date invalide";
			date = new Date();
		    return "add.jsf?faces-redirect=true";

		} 
	    
		if(eventEdit.getPlaces()<=0){
			 addError = "place invalide";
		      return "add.jsf?faces-redirect=true";
		}
		if(eventEdit.getName().length()==0){
			 addError = "nom invalide";
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
			return "Déja Abonné";
		else
			return "Abonnez-Vous";
	}
	
	

	public boolean isSubscribed() {
		boolean resutlt = false;
		for(Event e :serviceEvent.getAllEventsByUser(SessionUtils.getUser().getId()) ) {
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
	
	public String sendSms(String author,String text,String number) {
		try {
			// Construct data
			String apiKey = "apikey=" + URLEncoder.encode("vhlVnMKBHCg-7sk4i9t8jEFE4BSHggDnObTVXYci9A", "UTF-8");
			String message = "&message=" + URLEncoder.encode(text, "UTF-8");
			String sender = "&sender=" + URLEncoder.encode(author, "UTF-8");
			String numbers = "&numbers=" + URLEncoder.encode(number, "UTF-8");

			// Send data
			String data = "https://api.txtlocal.com/send/?" + apiKey + numbers + message + sender;
			URL url = new URL(data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sResult="";
			while ((line = rd.readLine()) != null) {
			// Process line...
				sResult=sResult+line+" ";
			}
			rd.close();

			return sResult;
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
	
	
	
	
	
}
