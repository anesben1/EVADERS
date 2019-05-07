package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.Commande;
import entity.Event;
import entity.Notif;
@Remote
public interface ServiceCommandeRemote {
	
	public Commande find(int id);
	public void add(Commande notif);
	public void update(Commande notif);
	public void delete(int id);
	public List<Commande> getCommandes();
	public List<Commande> getCommandesByUser(int idu);	

}
