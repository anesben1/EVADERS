package Bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Post;
import services.servicePostulationLocal;

@ManagedBean
@SessionScoped
public class PostBean implements Serializable {
	
	@EJB	
	private servicePostulationLocal servicePostulationLocal;
	private static final long serialVersionUID = 1L;
	
	
	private Post post;
	private servicePostulationLocal service;
	
	
	 public String creatPost() {
	       return "ok";
	    }
	
	
}
