package client;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entity.CategorieAV;
import entity.CategorieRec;
import entity.Notif;
import entity.Reclamation;
import entity.ServiceAV;
import services.ReclamationRemote;
import services.SAVRemote;
import services.ServiceNotifRemote;

@ManagedBean
@RequestScoped
public class ReclamationClientBean {
	
	public static int userID = 2;
	
	public String desctiption;
	public CategorieRec catr;
	public CategorieAV catav;
	@EJB
	ReclamationRemote serviceReclamation;
	
	@EJB
	SAVRemote serviceAV;

	@EJB
	ServiceNotifRemote notifRemote;
	
	public List<Reclamation> getMyReclamations() {
		return serviceReclamation.getReclamationByUser(userID);
	}
	
	public List<ServiceAV> getMyServices() {
		return serviceAV.getServicesByUser(userID);
	}
	
	public String addReclamation() {
		
		Notif notif = new Notif();
		notif.setIdUser(userID);
		notif.setIsChecked(0);
		notif.setDate(new Date());
		notif.setType("Reclamation");
		notif.setContent("Ajout Reclamation");	
		notifRemote.add(notif);
		
		Reclamation r = new Reclamation();
		r.setDateRec(new Date());
		r.setEtat(false);
		r.setTreated(false);
		r.setIduser(userID);
		r.setSujet(desctiption);
		r.setCategorieRec(catr);
		serviceReclamation.addRec(r);
		return "me.jsf";
	}
	
	public String addService() {
		
		
		Notif notif = new Notif();
		notif.setIdUser(userID);
		notif.setIsChecked(0);
		notif.setDate(new Date());
		notif.setType("Service");
		notif.setContent("Ajout Service");	
		notifRemote.add(notif);
		
		ServiceAV r = new ServiceAV();
		r.setDateSAV(new Date());
		r.setEtat(false);
		r.setTreated(false);
		r.setIdUser(userID);
		r.setCategorieAV(catav);
		r.setSujet(desctiption);
		serviceAV.addSAV(r);
		return "me.jsf";
	}
	
	public CategorieRec[] getCategoriRec() {
		return CategorieRec.values();
	}
	
	public CategorieAV[] getSavCat() {
		return CategorieAV.values();
	}

	public String getDesctiption() {
		return desctiption;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	public CategorieRec getCatr() {
		return catr;
	}

	public void setCatr(CategorieRec catr) {
		this.catr = catr;
	}

	public CategorieAV getCatav() {
		return catav;
	}

	public void setCatav(CategorieAV catav) {
		this.catav = catav;
	}
	
	
	
		

}
