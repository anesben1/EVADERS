package Bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.User;
import services.ServiceUser;

@ManagedBean( name = "userView")
@SessionScoped
public class UserView  implements Serializable{
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
    private String password;
    private User currentUser;
    private Boolean loggedIn;
   @EJB
   ServiceUser service ;
 
    public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String save() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome " + email));
        String navigateTo = "null"; 
		setCurrentUser(service.ReturnUserbymailpwd(email,password)); 

		if (currentUser != null && currentUser.getRole().equals("Candidat")) {
			navigateTo = "/pages/AddBlog?faces-redirect=true";
			setLoggedIn(true); 
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
    }



	public User getCurrentUser() {
		currentUser = service.ReturnUserbyId(currentUser.getId());
		return currentUser;
	}



	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}



	public Boolean getLoggedIn() {
		return loggedIn;
	}



	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}