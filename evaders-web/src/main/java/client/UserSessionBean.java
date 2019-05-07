package client;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Event;
import entity.User;
import services.ServiceEventRemote;
import services.ServiceUser;

@ManagedBean
@SessionScoped
public class UserSessionBean {

	@EJB
	ServiceEventRemote serviceEvent;
	@EJB
	ServiceUser serviceUser;
	
	private String login;
	private String password;
	public  User currentUser ;
	public String errorLogin="";
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	
	
	public String getErrorLogin() {
		return errorLogin;
	}


	public void setErrorLogin(String errorLogin) {
		this.errorLogin = errorLogin;
	}


	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String verifLogin() {
		User u=null;
		try {
			u = serviceUser.ReturnUserbymailpwd(login, password);
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(u!= null) {
			currentUser = u;
			errorLogin="";
			return "event/home.jsf?faces-redirect=true";
		}
		errorLogin = "Email et /ou mdp est incorrect";
		return "login.jsf";
	}
	
	
	public boolean isMyEvent(Event e) {
		
		for(Event event : currentUser.getEvents()) {
			if(event.getOwner().getId() == currentUser.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	
}
