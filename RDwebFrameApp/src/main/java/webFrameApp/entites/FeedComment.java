package webFrameApp.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

/**
 * Entity implementation class for Entity: FeedComment
 *
 */
 
@Entity
public class FeedComment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private String Author;
	private Date commentDate;
	private String commentBody;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "postId")
	private FeedPost post;
	
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
 

	public FeedPost getPost() {
		return post;
	}

	public void setPost(FeedPost post) {
		this.post = post;
	}

	private static final long serialVersionUID = 1L;

	public FeedComment() {
		super();
	}

}
