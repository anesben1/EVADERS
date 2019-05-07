package services;

import java.util.List;

import javax.ejb.Remote;

import entity.ServiceAV;

@Remote
public interface SAVRemote {

public void addSAV(ServiceAV sav);
	
	public void deleteSAV(int id);
	
	public List<ServiceAV> getSAVs();
	
	public void editSAV(ServiceAV sav, int id);
	
	public ServiceAV getSAVById(int id);
	
	public List<ServiceAV> rech(String s);
	
	public List<ServiceAV> getServicesByUser(int id);


}
