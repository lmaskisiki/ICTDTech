package webFrameApp.serviceLgoic;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import webFrameApp.entites.FeedPost;
import webFrameApp.interfaces.FeedPostDAO;
import webFrameApp.repositories.FeedPostRepo;

 
@WebService(endpointInterface="webFrameApp.interfaces.FeedPostDAO",name ="NewsFeedSEI", serviceName="NewsFeedService", portName="NewsFeedServicePort")
@Component
public class FeedPostImpl extends SpringBeanAutowiringSupport implements FeedPostDAO {
	@Autowired
	FeedPostRepo repo;

	@Override
	public void createPost(FeedPost post) {
		repo.save(post);
	} 
	@Override
	public List<FeedPost> listPosts() {
		List<FeedPost> listPost = repo.findAll();
		return listPost;

	} @Override
	public FeedPost findById(int id) {
		System.out.println("get data");
		FeedPost p = repo.findOne(id);
		System.out.println(p.getAuthor()+" is the name found");
 		return p;
	} @Override
	public String sayHi(String name) {
	
		return "Hello "+name+"";
	}

}
