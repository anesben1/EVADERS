package services;


import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entity.Event;
import entity.User;

import java.time.LocalDate;
import java.util.*;


/**
 * Session Bean implementation class ServiceUser
 */
@Stateful
public class ServiceEvent implements ServiceEventLocal,ServiceEventRemote{

	@PersistenceContext(name="pi-ejb")
	EntityManager em;
	@Override
	public void add(Event event) {
		// TODO Auto-generated method stub
		em.persist(event);
	}

	@Override
	public void update(Event event) {
		// TODO Auto-generated method stub
		em.merge(event);
	}

	@Override
	public void delete(int eventId) {
		// TODO Auto-generated method stub
		Event e = em.find(Event.class, eventId);
		if(e != null)
			em.remove(e);
	}

	@Override
	public void subscribeEvent(int eventId, int userId) {
		// TODO Auto-generated method stub
		Event event = em.find(Event.class, eventId);
		User user = em.find(User.class, userId);
		
		if(user != null && event  != null && event.getPlaces()>0) {
			event.addUser(user);
			event.setPlaces(event.getPlaces()-1);
			em.merge(event);
		}
		
	}

	@Override
	public void unSubscribeEvent(int eventId, int userId) {
		Event event = em.find(Event.class, eventId);
		User user = em.find(User.class, userId);
		if(user != null && event  != null) {
			event.setPlaces(event.getPlaces()+1);
			event.removeUser(user);
			em.merge(event);
		}

	}

	@Override
	public List<Event> getAllEvents() {
		Query q= em.createQuery("select e from Event e");
		try  {
			return q.getResultList();
	
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public List<Event> getAllEventsByEntreprise(int userId) {
		// TODO Auto-generated method stub
		Query jpql = em.createQuery("select e from Event e where e.owner=:l");
		jpql.setParameter("l", em.find(User.class, userId));
		try  {
			return jpql.getResultList();	
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public List<Event> getAllEventsByUser(int userId) {
		// TODO Auto-generated method stub
		 return em.createQuery( "SELECT p FROM Event p JOIN p.users e WHERE e.id = :idu")
		 .setParameter("idu", userId)
		 .getResultList();
	}

	@Override
	public List<Event> getAllEventsByName(String word) {
		// TODO Auto-generated method stub
		 return em.createQuery( "SELECT p FROM Event p  WHERE p.name like :word")
				 .setParameter("word", "%"+word+"%")
				 .getResultList();
	}

	@Override
	public List<Event> getAllEventsByDate(Date d1, Date d2) {
		long ltime=d2.getTime()+24*60*60*1000;
		Date d2more=new Date(ltime);
		Query jpql = em.createQuery("select e from Event e WHERE e.date >= :start AND e.date < :end")
				 .setParameter("start", d1)
				 .setParameter("end", d2more);

		return jpql.getResultList();
	}
	
	@Override
	public List<Event> getAvailableEvents() {
		Query jpql = em.createQuery("select e from Event e WHERE e.date > :now and e.enabled = true")
				 .setParameter("now", new Date());

		return jpql.getResultList();
	}
	
	@Override
	public List<Event> getBestEvents() {
		//Query jpql = em.createQuery("select e from Event e Right JOIN e.users u group By e.id");
		Query jpql = em.createQuery("select e.name as title , e.date as start from event e");

		return jpql.getResultList();
	}
	
	
	@Override
	public List<Event> getAvailablePlaceEvents() {
		Query jpql = em.createQuery("select e from Event e WHERE e.date > :now and e.enabled = true and e.places >0")
				 .setParameter("now", new Date());

		return jpql.getResultList();
	}

	@Override
	public List<Event> getAllEventsByStatus(boolean status) {
		Query jpql = em.createQuery("select e from Event e where e.enabled = :status")
				 .setParameter("status", status);

		return jpql.getResultList();
	}

	@Override
	public void setStatusEvent(int eventId) {
		Event  e = em.find(Event.class, eventId);
		if(e.isEnabled())
			e.setEnabled(false);
		else
			e.setEnabled(true);
		em.merge(e);
		
	}

	@Override
	public Event find(int id) {
		// TODO Auto-generated method stub
		return em.find(Event.class, id);
	}
   
}
