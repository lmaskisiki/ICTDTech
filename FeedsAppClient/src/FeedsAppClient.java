import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import feedsApp.entities.Feeds;
import feedsApp.sessionBeans.FeedServiceRemote;


public class FeedsAppClient {

	public FeedsAppClient() {
		 
	}

	public static void main(String[] args) throws NamingException {
		System.out.println("Call initial context...");
		FeedServiceRemote service=(	FeedServiceRemote ) InitialContext.doLookup("FeedsApp/FeedService!feedsApp.sessionBeans.FeedServiceRemote");
		Feeds f=new Feeds();
		
		// f.setPostDate((java.sql.Date) new Date());
		 f.setBody("the story of earch and life");
		 f.setTitle("My story");
		 f.setWriter("Masikisiki lizo");
		service.CreateFeed(f);
		
		
		
		try{
			Thread.sleep(Integer.MAX_VALUE);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
