package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.Event;
@Remote
public interface ServiceEventRemote {
	
	public Event find(int id);
	public void add(Event event);
	public void update(Event event);
	public void delete(int eventId);
	public void subscribeEvent(int eventId,int userId);
	public void setStatusEvent(int eventId);
	public void unSubscribeEvent(int eventId,int userId);
	public List<Event> getAllEvents();
	public List<Event> getAllEventsByStatus(boolean status);
	public List<Event> getAllEventsByEntreprise(int userId);
	public List<Event> getAllEventsByUser(int userId);
	public List<Event> getAllEventsByName(String word);
	public List<Event> getAllEventsByDate(Date d1, Date d2);
	public List<Event> getAvailableEvents();
	public List<Event> getAvailablePlaceEvents();
	public List<Event> getBestEvents();


}
