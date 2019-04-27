package services;

import java.util.List;

import javax.ejb.Remote;

import entity.Application;
import entity.Entreprise_Profile;
import entity.Offer;


@Remote
public interface servicePostulationRemote {
	public void AjouterPostulation(Application app);
	public void DeleteApplication(Application app);
	public void AccepterApplication(Application app);
	public void RefuserApplication(Application app);
	public Application ReturnAppbyId (int Id);
	
	
}
