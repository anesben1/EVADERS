package Bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;



import javax.annotation.PostConstruct;



import entity.Post;

import services.ServiceUser;
import services.servicePublicationLocal;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PostBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB	
	private servicePublicationLocal servicePublicationLocal;
	
	@EJB
	private ServiceUser serviceUser;
	
	
	private Post post;
	public String titre,type,contenue;
	private List<Post>  postList  ; 
	
	@PostConstruct
	public void init() {
		postList = servicePublicationLocal.findAll();
		post = new Post();
	}
	
	
	

	public PostBean() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getContenue() {
		return contenue;
	}




	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	public String creatPost() {
		// User u = serviceUser.ReturnUserbyId(userID);
		System.out.println("start creating post");
		 String navigateTo = "/Blog?faces-redirect=true";
		   this.post.setTitre(titre);
		   this.post.setType(type);
		   this.post.setContent(contenue);
		  // User u =new User();
		 //  u.setId(1);
		  // this.post.setUsersPosts(u);
		   
		   servicePublicationLocal.creatPost(post);
		    System.out.println("post created");

			return navigateTo;
		    
			//date = formatter4.format(new Date());
			
			//Post p = new Post();
			
			//post.setDate(date);
			
	    }




	public servicePublicationLocal getServicePublicationLocal() {
		return servicePublicationLocal;
	}


	public void setServicePublicationLocal(servicePublicationLocal servicePublicationLocal) {
		this.servicePublicationLocal = servicePublicationLocal;
	}


	public ServiceUser getServiceUser() {
		return serviceUser;
	}




	public void setServiceUser(ServiceUser serviceUser) {
		this.serviceUser = serviceUser;
	}




	public Post getPost() {
		return post;
	}




	public void setPost(Post post) {
		this.post = post;
	}




	
	public String getTitre() {
		return titre;
	}




	public void setTitre(String titre) {
		this.titre = titre;
	}




	public List<Post> getPostList() {
		return postList;
	}




	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}



	
	
}
