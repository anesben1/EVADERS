package services;

import java.util.List;

import javax.ejb.Remote;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import entity.User;

@Remote
public interface ServiceUserRemote {

	
	public int creatUser(User user);
	public void DelateUser(User user);
	public void UpdateUser(User user);
	public void RemoveUser(User user);
	public User ReturnUserbyId (int Id);
	public List<User> ReturnUsersbyName (String firstName,String lastName);
	public List<User> ReturnUsersbyRole (String Role);
	public User ReturnUserbymailpwd (String email, String  pwd);
	public Boolean LoginVerification(String email, String  pwd);
	int sendConfirmationCode(User user) ;
	
	
	
}
