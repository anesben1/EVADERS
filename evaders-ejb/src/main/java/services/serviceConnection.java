package services;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Condidate_Profile;
import entity.Connection;
import entity.User;

/**
 * Session Bean implementation class serviceConnection
 */

@Stateless
@LocalBean
public class serviceConnection implements serviceConnectionRemote, serviceConnectionLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="evaders-ejb")
	EntityManager em;
    public serviceConnection() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creatConnection(Connection connection) {
		// TODO Auto-generated method stub
		em.persist(connection);	
	}

	@Override
	public void DeleteConnection(Connection connection) {
		// TODO Auto-generated method stub
		connection = ReturnConnectionbyId(connection.getId());
		em.remove(connection);
	}

	@Override
	public Connection ReturnConnectionbyId(int Id) {
		// TODO Auto-generated method stub
		return em.find(Connection.class,Id);
	}

	@Override
	public Connection ReturnConnectionbyUsers(User user1, User user2) {
		// TODO Auto-generated method stub
		TypedQuery<Connection> query = em.createQuery("SELECT c FROM Connection c WHERE c.CondidateConnected = :condidate1 AND c.ConnectedtoCondidate = :condidate2",Connection.class);			
		Connection connection = query.setParameter("condidate1", user1.getProfil()).setParameter("condidate2", user2.getProfil()).getSingleResult();
		return connection;
	}


	


}
