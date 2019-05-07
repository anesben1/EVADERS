package services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Commande;
import entity.Condidate_Profile;
import entity.Connection;
import entity.User;

/**
 * Session Bean implementation class serviceConnection
 */

@Stateless
@LocalBean
public class ServiceCommande implements ServiceCommandeRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="evaders-ejb")
	EntityManager em;

	@Override
	public Commande find(int id) {
		return em.find(Commande.class, id);
	}

	@Override
	public void add(Commande cmd) {
		em.persist(cmd);
	}

	@Override
	public void update(Commande cmd) {
		// TODO Auto-generated method stub
		em.merge(cmd);
		
	}

	@Override
	public void delete(int id) {
		em.remove(em.find(Commande.class, id));		
	}

	@Override
	public List<Commande> getCommandes() {
		Query q= em.createQuery("select c from Commande c");
		return q.getResultList();
	}

	@Override
	public List<Commande> getCommandesByUser(int idu) {
		Query q= em.createQuery("select c from Commande c where c.idUser="+idu);
		return q.getResultList();
	}

}
