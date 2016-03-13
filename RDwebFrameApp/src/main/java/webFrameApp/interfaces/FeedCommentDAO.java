package webFrameApp.interfaces;

import webFrameApp.entites.FeedComment;
import webFrameApp.entites.FeedPost;

public interface FeedCommentDAO {
	
	public void Addcomment(FeedPost post,FeedComment comment);
	public void Removecomment(FeedComment comment);
	public void Listcomments(FeedPost post);

}
