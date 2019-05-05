package services;




import java.util.Map;

import javax.ejb.Remote;

import entity.Condidate_Profile;
import entity.Connection;

import entity.User;

@Remote
public interface serviceConnectionRemote {
	public void creatConnection(Connection connection);
	public void DeleteConnection(Connection post);
	public Connection ReturnConnectionbyId (int Id);
	public Connection ReturnConnectionbyUsers (User user1,User user2);

}
