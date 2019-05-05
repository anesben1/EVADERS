package client;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Event;
import services.ServiceEventRemote;

@ManagedBean
@SessionScoped
public class EventSessionClientBean {
	public static final int userID = 2;
	@EJB
	ServiceEventRemote serviceEvent;
		
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
}
