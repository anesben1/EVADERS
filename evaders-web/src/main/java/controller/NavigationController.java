package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
@SessionScoped
public class NavigationController implements Serializable {

	   public String moveToPage1() {
		      return "page1";
		   }
}
