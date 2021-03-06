package admin;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entity.Commande;
import entity.Notif;
import entity.Reclamation;
import entity.ServiceAV;
import entity.User;
import services.ReclamationRemote;
import services.SAVRemote;
import services.ServiceCommandeRemote;
import services.ServiceNotif;
import services.ServiceNotifRemote;
import services.ServiceUserRemote;

@ManagedBean
@RequestScoped
public class ReclamationBean {
	
	@EJB
	ReclamationRemote serviceReclamation;
	@EJB
	ServiceNotifRemote serviceNotif;
	@EJB
	SAVRemote serviceAV;	
	@EJB
	ServiceCommandeRemote serviceCmd;	
	@EJB
	ServiceUserRemote serviceUser;	

	public List<ServiceAV> getServiceAV() {
		return serviceAV.getSAVs();
	}
	public String doTreatServiceAV(ServiceAV sav) {
		User owner = serviceUser.ReturnUserbyId(sav.getIdUser());
		sendEmail("Approuver Reclamation", owner.getEmail(), "votre service demande a été traité");

		sav.setTreated(true);
		serviceAV.editSAV(sav, sav.getIdSAV());
		
		return "serviceav.jsf?faces-redirect=true";
	}
	public List<Reclamation> getReclamations() {
		return serviceReclamation.getRecs();
	}
	
	public String doTreatReclamation(Reclamation r) {
		User owner = serviceUser.ReturnUserbyId(r.getIduser());
		sendEmail("Approuver Reclamation", owner.getEmail(), "votre reclamation a été traité");
		r.setTreated(true);
		serviceReclamation.editRec(r, r.getIdRec());
		return "entretien.jsf";
	}
	
	public List<Notif> getAllNotifs(){
		return serviceNotif.getNotifs();
	}
	
	public List<Commande> getCommandes(){
		return serviceCmd.getCommandes();
	}
	
	
	public String setSeen(Notif notif) {
		serviceNotif.seenNotif(notif.getId());
		String type = notif.getType().toLowerCase();
		if( notif.getType().toLowerCase().equals("reclamation"))
			return "reclamation/entretien.jsf?faces-redirect=true";
		else
			return "reclamation/serviceav.jsf?faces-redirect=true";
				
	}
	

	 public static void sendEmail(String subject,String email,String contenu) {

	        final String username = "rassil.benrhouma@esprit.tn";
	        final String password = "AcerM5600";

	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(email));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(email)
	            );
	            message.setSubject(subject);
	            message.setText(contenu );

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
}
