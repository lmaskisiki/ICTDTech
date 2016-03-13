package feedsApp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FeedList")
public class FeedList  {
 

	private List<Feeds> listFeeds=new ArrayList<Feeds>();
	
	@XmlElement 
	public List<Feeds> getListFeeds() {
		return listFeeds;
	}

	public void setListFeeds(List<Feeds> listFeeds) {
		this.listFeeds = listFeeds;
	}
	
	
	

 
	
 
 

}
