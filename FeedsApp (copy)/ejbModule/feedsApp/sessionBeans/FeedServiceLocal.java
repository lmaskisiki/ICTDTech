package feedsApp.sessionBeans;

import java.util.List;

import javax.ejb.Local;

import feedsApp.entities.Feeds;

@Local
public interface FeedServiceLocal {
	public boolean CreateFeed(Feeds feed);
	public boolean Destroy(int feedId);
	 public List<Feeds> Listfeeds();
 	 public Feeds FindById(int  feedId);
}
