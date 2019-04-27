package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Application;
import entity.Entreprise_Profile;
import entity.Offer;
import entity.Post;
import entity.User;


/**
 * Session Bean implementation class servicePostulation
 */
@Stateless
@LocalBean
public class servicePostulation implements servicePostulationRemote, servicePostulationLocal {
	  /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="evaders-ejb")
	EntityManager em;
    public servicePostulation() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public void AjouterPostulation(Application app) {
		// TODO Auto-generated method stub
		app.setIsAccepted(0);
		//app.setUserapplies(a);
		//System.out.println(a);
		//LocalDateTime dateTime = LocalDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		//System.out.println(dateTime.format(formatter));  
		//app.setDate(dateTime);
		app.getUserapplies().getId();
		System.out.println(app.getUserapplies().getId());
		ServiceUser tools=new ServiceUser();
		User user=new User();
		user=tools.ReturnUserbyId(app.getUserapplies().getId());
		app.setUserapplies(user);
		em.persist(app);
	}

	@Override
	public void DeleteApplication(Application app) {
		// TODO Auto-generated method stub
		em.remove(app);
		
	}

	@Override
	public Application ReturnAppbyId(int Id) {
		// TODO Auto-generated method stub
		
		return em.find(Application.class, Id);
	}

	
	@Override
	public void AccepterApplication(Application app) {
		// TODO Auto-generated method stub
		app.setIsAccepted(1);
		em.merge(app);
		
	}

	@Override
	public void RefuserApplication(Application app) {
		// TODO Auto-generated method stub
		app.setIsAccepted(2);
		em.merge(app);
	}

}
