package Bean;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.User;

public class SessionUtils {


    public static HttpSession getSession(){
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest(){
        return  (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
    
    public static User getUser(){
        return (User) SessionUtils.getSession().getAttribute("user");
    }

    public static boolean isLogged(){
        return SessionUtils.getSession().getAttribute("user")!=null;
    }

}
