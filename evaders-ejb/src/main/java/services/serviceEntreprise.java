package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Condidate_Profile;
import entity.Entreprise_Profile;
import entity.User;

/**
 * Session Bean implementation class serviceEntreprise
 */
@Stateless
@LocalBean
public class serviceEntreprise implements serviceEntrepriseRemote, serviceEntrepriseLocal {

    /**
     * Default constructor. 
     */
    public serviceEntreprise() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="evaders-ejb")
	 EntityManager em;
	@Override
	public int addEntrepriseProfile(Entreprise_Profile entreprise_Profile) {
		em.persist(entreprise_Profile);
		return entreprise_Profile.getId();
	}
	@Override
	public int affectUser(int userId, int profileId) {
		User user = em.find(User.class, userId);
		Entreprise_Profile entreprise_Profile = em.find(Entreprise_Profile.class, profileId);
		entreprise_Profile.setUser(user);		
		return entreprise_Profile.getId();
	}
    

}
