package feedsApp.sessionBeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import feedsApp.entities.Feeds;

/**
 * Session Bean implementation class FeedService
 */
@Stateless
public class FeedService implements FeedServiceRemote, FeedServiceLocal {
	@PersistenceContext(unitName="FeedsApp")
	private EntityManager em;

	@Override
	public boolean CreateFeed(Feeds feed) {
		 em.persist(feed);
		return false;
	}

	@Override
	public boolean Destroy(int feedId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Feeds> Listfeeds() {
		 
		return em.createQuery("SELECT e From Feeds e").getResultList();
	}

	@Override
	public Feeds FindById(int feedId) {
		// TODO Auto-generated method stub
		return null;
	}

}
