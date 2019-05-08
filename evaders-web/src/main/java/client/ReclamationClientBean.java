package client;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Bean.SessionUtils;
import entity.CategorieAV;
import entity.CategorieRec;
import entity.Commande;
import entity.Notif;
import entity.Reclamation;
import entity.ServiceAV;
import services.ReclamationRemote;
import services.SAVRemote;
import services.ServiceCommande;
import services.ServiceCommandeRemote;
import services.ServiceNotifRemote;

@ManagedBean
@RequestScoped
public class ReclamationClientBean {
	
	public static int userId= 2;
	public String price;
	public int quantity;
	public String desctiption;
	public CategorieRec catr;
	public CategorieAV catav;
	@EJB
	ReclamationRemote serviceReclamation;
	
	@EJB
	SAVRemote serviceAV;

	@EJB
	ServiceCommandeRemote serviceCmd;

	@EJB
	ServiceNotifRemote notifRemote;
	
	public List<Reclamation> getMyReclamations() {
		return serviceReclamation.getReclamationByUser(SessionUtils.getUser().getId());
	}
	
	public List<ServiceAV> getMyServices() {
		return serviceAV.getServicesByUser(SessionUtils.getUser().getId());
	}
	
	public String addReclamation() {
		
		Notif notif = new Notif();
		notif.setIdUser(SessionUtils.getUser().getId());
		notif.setIsChecked(0);
		notif.setDate(new Date());
		notif.setType("Reclamation");
		notif.setContent("Ajout Reclamation");	
		notifRemote.add(notif);
		
		Reclamation r = new Reclamation();
		r.setDateRec(new Date());
		r.setEtat(false);
		r.setTreated(false);
		r.setIduser(SessionUtils.getUser().getId());
		r.setSujet(desctiption);
		r.setCategorieRec(catr);
		serviceReclamation.addRec(r);
		return "me.jsf";
	}
	
	public String addService() {
		
		
		Notif notif = new Notif();
		notif.setIdUser(SessionUtils.getUser().getId());
		notif.setIsChecked(0);
		notif.setDate(new Date());
		notif.setType("Service");
		notif.setContent("Ajout Service");	
		notifRemote.add(notif);
		
		ServiceAV r = new ServiceAV();
		r.setDateSAV(new Date());
		r.setEtat(false);
		r.setTreated(false);
		r.setIdUser(SessionUtils.getUser().getId());
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
	
	public String orderAction(){
		Commande c = new Commande();
		c.setIdUser(SessionUtils.getUser().getId());
		c.setDate(new Date());
		c.setPrice(Float.valueOf(price));
		c.setQuantity(quantity);
		c.setTypePayement("paypal");
		serviceCmd.add(c);
		
		return "";
	}

	public List<Commande> getMyCommandes(){
		return serviceCmd.getCommandesByUser(SessionUtils.getUser().getId());
	}
	
	
	
		

}
