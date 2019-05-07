package services;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Pack;
@Stateful
public class PackServices implements PackRemote{

	@PersistenceContext(name="pi-ejb")
	EntityManager em;
	
	@Override
	public void addPack(Pack pack) {
		// TODO Auto-generated method stub
		em.persist(pack);
	}

	@Override
	public void deletePack(int id) {
		// TODO Auto-generated method stub
		Pack p = em.find(Pack.class, id);
		em.remove(p);
		
	}

	@Override
	public List<Pack> getPacks() {
		// TODO Auto-generated method stub
		return em.createQuery("from Pack", Pack.class).getResultList();
	}

	@Override
	public void editPack(Pack pack, int id) {
		// TODO Auto-generated method stub
		Pack p = em.find(Pack.class, id);
		p.setEtat(pack.isEtat());
		p.setNbre_offres(pack.getNbre_offres());
		p.setPrix(pack.getPrix());
		p.setNom(pack.getNom());
		em.persist(p);
		em.flush();
	}

	@Override
	public Pack getPackById(int id) {
		// TODO Auto-generated method stub
		return em.find(Pack.class, id);
	}

}
