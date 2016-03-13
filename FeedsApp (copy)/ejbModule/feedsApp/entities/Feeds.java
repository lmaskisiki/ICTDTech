package feedsApp.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Feeds
 *
 */
@Entity
public class Feeds implements Serializable {
	   
	@Id

	private int feedId;
	private String title;
	private String body;
	private String writer;
	private Date postDate;
	private String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	private static final long serialVersionUID = 1L;

	public Feeds() {
		super();
	}   
	public int getFeedId() {
		return this.feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}   
	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}   
	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
   
}
