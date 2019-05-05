package Bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;



@ManagedBean
public class my  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public my() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String testRedirect() {
		return "/AddBlog.jsf";
	}
}
