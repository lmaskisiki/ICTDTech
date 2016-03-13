package feedsApp.sessionBeans;

import java.util.List;

import javax.ejb.Remote;

import feedsApp.entities.Feeds;

@Remote
public interface FeedServiceRemote {
	
	public boolean CreateFeed(Feeds feed);
	public boolean Destroy(int feedId);
	 public List<Feeds> Listfeeds();
 	 public Feeds FindById(int  feedId);
 	 
	 
		

}
