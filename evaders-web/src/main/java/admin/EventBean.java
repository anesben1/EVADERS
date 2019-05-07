package admin;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entity.Event;
import entity.User;
import services.ServiceEventRemote;
import services.serviceStatRemote;

@ManagedBean
@RequestScoped
public class EventBean {
	
	@EJB
	ServiceEventRemote serviceEvent;
	
	@EJB
	serviceStatRemote serviceStat;
		
		

	public List<Event> getAllEvents(){
		return serviceEvent.getAllEvents();
	}
	
	public String setActiveEvent(Event e){
		serviceEvent.setStatusEvent(e.getId());
		return "list.jsf?faces-redirect=true";
	}
	
	
	
	public String deleteEvent(Event e){
		serviceEvent.delete(e.getId());
		return "list.jsf?faces-redirect=true";
	}
	
	public String doCheckEvents(){
		User u = new User();
		u.setId(1);
	//	int nb = serviceStat.getNbOfferByEntrepriseByMonth(u, 5);
		//System.out.println(" ************** "+nb);
		for(Event e : serviceEvent.getAllEvents()) {
			if(e.getDate().before(new Date())) {
				if(e.isEnabled()) {
					serviceEvent.setStatusEvent(e.getId());
				}
			}
		}
		return "list.jsf?faces-redirect=true";
	}
	
	
	public String getStatusAction(Event e) {
		if(e.isEnabled())
			return "Désactiver";
		return "Activer";
	}
}
