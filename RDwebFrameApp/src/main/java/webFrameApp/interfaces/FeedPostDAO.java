package webFrameApp.interfaces;

import java.util.List;

 
  

import javax.jws.WebService;

import webFrameApp.entites.FeedPost;

@WebService
public interface FeedPostDAO {
	public void createPost(FeedPost post);
	public List<FeedPost> listPosts();
	 
	public FeedPost findById(int id);
 
	public String sayHi(String name);

}
