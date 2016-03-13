package feedsClientApp.mbeans;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBException;

import feedsApp.entities.Feeds;
import feedsApp.sessionBeans.FeedServiceRemote;
import feedsClientApp.marshalling.Marshaler;





@ManagedBean
@SessionScoped
public class ClientController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String body;
	private String writer;
	private String category;
	private String postDate;
	Feeds feed = new Feeds();
	private boolean editable;
	private TempFeed currentFeed;
	private List<Feeds> allFeeds;
	
	
	private SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
	@EJB
	FeedServiceRemote service;
	@Inject 
	jmsSender send;
	@PostConstruct
	public void home() throws JAXBException{
		allFeeds = service.Listfeeds();
		new Marshaler();
	}
	
	
	
	
	public TempFeed getCurrentFeed() {
		return currentFeed;
	}

	public void setCurrentFeed(TempFeed currentFeed) {
		this.currentFeed = currentFeed;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean enditable) {
		this.editable = enditable;
	}

	public Feeds getFeed() {
		return feed;
	}

	public void setFeed(Feeds feed) {
		this.feed = feed;
	}



	public List<Feeds> getAllFeeds() {
		return allFeeds;
	}

	public void setAllFeeds(List<Feeds> allFeeds) {
		this.allFeeds = allFeeds;
	}

	

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ClientController() {

	}

	public String showFeed() throws ParseException, NamingException, JAXBException {
		Date d = new java.sql.Date(fmtDate.parse(getPostDate()).getTime());
Marshaler ms=new Marshaler();
		feed.setBody(getBody());
		feed.setTitle(getTitle());
		feed.setWriter(getWriter());
		feed.setPostDate(d);
	 
		feed.setCategory(getCategory());
		
		String xmlString=ms.XmlData(feed);
		send.sendMessage(xmlString);
		//System.out.println("XML data : \n \n"+xmlString);
		
		
		//service.CreateFeed(feed);

		return "showcreated";
	}

	public String showFeeds() {
		allFeeds = service.Listfeeds();
		return "showfeeds";
	}

	public String editRow() {
		currentFeed.setEnitable(true);
		return null;
	}

	public String removeRow(Feeds feed) {
		service.Destroy(feed);
		allFeeds.remove(feed);
		return null;
	}

	public String viewFeed(Feeds f) {
		currentFeed = new TempFeed();
		currentFeed.setEnitable(false);
		currentFeed.setFeed(f);
		return "editfeed";

	}

	public String saveChanges(Feeds feed) {
		currentFeed.setFeed(feed);
		currentFeed.setEnitable(false);
		return null;
	}

 	public java.util.Date String_toDate(String strDate) throws ParseException{
		java.util.Date d=fmtDate.parse(strDate);
	 //return new java.sql.Date(d.getTime());
		 return d;
	}
 	
 
 	
 	
}
