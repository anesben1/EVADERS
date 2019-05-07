package services;

import java.util.List;

import javax.ejb.Remote;

import entity.Pack;

@Remote
public interface PackRemote {
	
	public void addPack(Pack pack);
	
	public void deletePack(int id);
	
	public List<Pack> getPacks();
	
	public void editPack(Pack pack, int id);
	
	public Pack getPackById(int id);
	
	

}
