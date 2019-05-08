package client;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Bean.SessionUtils;
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
		User user=null;
        HttpSession session = SessionUtils.getSession();

		try {
			user = serviceUser.ReturnUserbymail(login);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		if(user!= null) {
		    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    if(passwordEncoder.matches(password,user.getPassword())){
	            session.setAttribute("user", user);
	            currentUser = user;
				errorLogin="";
		    	if(user.getRole().toLowerCase().contains("admin")){
		    		return "admin/event/list.jsf?faces-redirect=true";
		    	}else{
					return "event/home.jsf?faces-redirect=true";
		    	}
		    	
		    }
		}
		errorLogin = "Email et /ou mdp est incorrect";
		return "/evaders-web/login.jsf";
	}
	
	public String doLogin(){
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

		return ec.getRequestContextPath()+"/login.jsf";
	}
	
	public String doLogout(){
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("user", null);
		currentUser = null;

		return "login.jsf";
	}
	
	
	public boolean isMyEvent(Event e) {
		
		if(currentUser != null)
		for(Event event : currentUser.getEvents()) {
			if(event.getOwner().getId() == currentUser.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	
}
