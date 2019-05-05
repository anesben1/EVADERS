package services;

import java.util.List;

import javax.ejb.Local;

import entity.Post;
import entity.User;

@Local
public interface servicePublicationLocal {

	public void creatPost(Post post);
	public void DeletePost(Post post);
	public void UpdatePost(Post post);
	public Post ReturnPostbyId (int Id);
	public List<Post> ReturnPostsbyUser (User user);
	public List<Post> ReturnPostbyConnectionsandfollows (User user);
	public List<Post> findAll();
}
