package services;


import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import entity.User;

/**
 * Session Bean implementation class ServiceUser
 */
@Stateless
@LocalBean


public class ServiceUser implements ServiceUserRemote, ServiceUserLocal {
    /**
     * Default constructor. 
     */
	@Resource(name="mail/myMailSession")
	private Session session;
	@PersistenceContext(unitName="evaders-ejb")
	EntityManager em;
    public ServiceUser() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public int creatUser(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return user.getId();
	}

	@Override
	public void DelateUser(User user) {
		// TODO Auto-generated method stub
	 user = ReturnUserbyId(user.getId());
	 em.remove(user);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		//user = ReturnUserbyId(user.getId());
		em.merge(user);	
	}

	@Override
	public void RemoveUser(User user) {
		// TODO Auto-generated method stub	
		em.remove(ReturnUserbyId(user.getId()));
	}

	@Override
	public User ReturnUserbyId(int Id) {
		// TODO Auto-generated method stub
		return em.find(User.class, Id);
	}

	@Override
	public List<User> ReturnUsersbyName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.first_name LIKE :firstname AND u.last_name LIKE :lastname",User.class);			
		List<User> users = query.setParameter("firstname", "'%"+firstName+"%'").setParameter("lastname", "'%"+lastName+"%'").getResultList();
		return users;
	}
    public static int ez;

	@Override
	public List<User> ReturnUsersbyRole(String Role) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.role = :role",User.class);			
		List<User> users = query.setParameter("role", Role).getResultList();
		return users;
	}
	public static User a=new User();
	

	@Override
	public User ReturnUserbymailpwd(String email, String pwd) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email  AND u.password = :pwd",User.class);			
		User user = query.setParameter("email", email).setParameter("pwd", pwd).getSingleResult();
		
		return user;
	}
 
	@Override
	public Boolean LoginVerification(String email, String pwd) {
		// TODO Auto-generated method stub
	    User user = ReturnUserbymailpwd(email, pwd);
	    ez= 5;
		return (user!=null);
	}


	@Override
	public int sendConfirmationCode(User user)  {
	Mail mail = new Mail();
	return mail.sendMail(user);

	}

	
}
