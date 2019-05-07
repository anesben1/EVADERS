package services;

import java.util.List;

import javax.ejb.Remote;

import entity.Reclamation;


@Remote
public interface ReclamationRemote {

	public void addRec(Reclamation rec);
	
	public void deleteRec(int id);
	
	public List<Reclamation> getRecs();
	
	public void editRec(Reclamation rec, int id);
	
	public Reclamation getRecById(int id);
	
	public List<Reclamation> rech(String s);
	
	public List<Reclamation> getReclamationByUser(int id);
}
