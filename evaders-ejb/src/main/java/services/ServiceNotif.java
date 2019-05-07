package services;


import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entity.Event;
import entity.Notif;
import entity.User;

import java.time.LocalDate;
import java.util.*;


/**
 * Session Bean implementation class ServiceUser
 */
@Stateful
public class ServiceNotif implements ServiceNotifRemote{

	@PersistenceContext(name="pi-ejb")
	EntityManager em;

	@Override
	public Notif find(int id) {
		// TODO Auto-generated method stub
		return em.find(Notif.class,id);
	}

	@Override
	public void add(Notif notif) {
		// TODO Auto-generated method stub
		em.persist(notif);
	}

	@Override
	public void update(Notif notif) {
		// TODO Auto-generated method stub
		em.merge(notif);
	}

	@Override
	public void delete(int notifId) {
		// TODO Auto-generated method stub
		em.remove(em.find(Notif.class, notifId));
	}

	@Override
	public void seenNotif(int id) {
		// TODO Auto-generated method stub
		Notif notif = em.find(Notif.class,id);
		notif.setIsChecked(1);
		em.merge(notif);		
	}

	@Override
	public List<Notif> getNotifs() {
		Query q= em.createQuery("select n from Notif n where n.isChecked = 0");
		try  {
			return q.getResultList();
	
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}
	
   
}
