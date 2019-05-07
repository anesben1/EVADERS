package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.Event;
import entity.Notif;
@Remote
public interface ServiceNotifRemote {
	
	public Notif find(int id);
	public void add(Notif notif);
	public void update(Notif notif);
	public void delete(int notifId);
	public void seenNotif(int id);
	public List<Notif> getNotifs();
	

}
