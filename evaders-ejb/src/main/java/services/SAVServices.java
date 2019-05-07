package services;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.ServiceAV;

@Stateful
public class SAVServices implements SAVRemote{

	@PersistenceContext(name="pi-ejb")
	EntityManager em;
	
	@Override
	public void addSAV(ServiceAV sav) {
		// TODO Auto-generated method stub
		em.persist(sav);
	}

	@Override
	public void deleteSAV(int id) {
		// TODO Auto-generated method stub
		ServiceAV sav = em.find(ServiceAV.class, id);
		em.remove(sav);
	}

	@Override
	public List<ServiceAV> getSAVs() {
		// TODO Auto-generated method stub
		Query q= em.createQuery("select s from ServiceAV s where s.treated=0");
		return q.getResultList();
	}
	
	@Override
	public List<ServiceAV> getServicesByUser(int id) {
		// TODO Auto-generated method stub
		Query q= em.createQuery("select s from ServiceAV s where s.idUser="+id);
		return q.getResultList();	
	}

	@Override
	public void editSAV(ServiceAV sav, int id) {
		// TODO Auto-generated method stub
		ServiceAV s = em.find(ServiceAV.class, id);
		s.setCategorieAV(sav.getCategorieAV());
		s.setDateSAV(sav.getDateSAV());
		s.setEtat(sav.isEtat());
		s.setSujet(sav.getSujet());
		s.setTreated(sav.isTreated());
		System.out.println("update sav please : "+sav.isTreated());
		em.persist(s);
		em.flush();
	}

	@Override
	public ServiceAV getSAVById(int id) {
		// TODO Auto-generated method stub
		return em.find(ServiceAV.class, id);
	}
	
	@Override
	public List<ServiceAV> rech(String s) {
		// TODO Auto-generated method stub
		Query q= em.createQuery("select s from ServiceAV s where s.sujet like :txt ");
		q.setParameter("txt","%" + s + "%");
		return q.getResultList();
	}

}
