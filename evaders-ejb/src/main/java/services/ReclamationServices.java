package services;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Reclamation;


@Stateful
public class ReclamationServices implements ReclamationRemote{

	@PersistenceContext(name="pi-ejb")
	EntityManager em;
	
	@Override
	public void addRec(Reclamation rec) {
		// TODO Auto-generated method stub
		em.persist(rec);
	}

	@Override
	public void deleteRec(int id) {
		// TODO Auto-generated method stub
		Reclamation rec = em.find(Reclamation.class, id);
		em.remove(rec);
	}

	@Override
	public List<Reclamation> getRecs() {
		// TODO Auto-generated method stub
		Query q= em.createQuery("select r from Reclamation r where r.treated=0");
		return q.getResultList();
	}

	@Override
	public void editRec(Reclamation rec, int id) {
		// TODO Auto-generated method stub
		Reclamation r = em.find(Reclamation.class, id);
		r.setCategorieRec(rec.getCategorieRec());
		r.setDateRec(rec.getDateRec());
		r.setEtat(rec.isEtat());
		r.setTreated(rec.isTreated());
		System.out.println("ddddddd"+rec.isTreated());
		r.setSujet(rec.getSujet());
		em.persist(r);
		em.flush();
	}

	@Override
	public Reclamation getRecById(int id) {
		// TODO Auto-generated method stub
		return em.find(Reclamation.class, id);
	}

	@Override
	public List<Reclamation> rech(String s) {
		// TODO Auto-generated method stub
		Query q= em.createQuery("select r from Reclamation r where r.sujet like :txt ");
		q.setParameter("txt","%" + s + "%");
		return q.getResultList();
	}
	
	@Override
	public List<Reclamation> getReclamationByUser(int id) {
		// TODO Auto-generated method stub
		Query q= em.createQuery("select r from Reclamation r where r.iduser="+id);
		return q.getResultList();
	}

}
