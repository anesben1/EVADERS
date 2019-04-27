package services;

import javax.ejb.Remote;

import entity.Entreprise_Profile;

@Remote
public interface serviceEntrepriseRemote {
	int addEntrepriseProfile(Entreprise_Profile entreprise_Profile);
	int affectUser(int userId,int profileId);


}
