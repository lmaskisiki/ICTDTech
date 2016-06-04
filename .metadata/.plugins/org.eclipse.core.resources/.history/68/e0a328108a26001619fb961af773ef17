package webFrameApp.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import webFrameApp.entites.FeedComment;
import webFrameApp.entites.FeedPost;

public interface FeedPostDAO {
	public void createPost(FeedPost post);
	public List<FeedPost> listPosts();
	@Transactional
	public FeedPost findById(int id);
	@Transactional
	public List<FeedComment> getComments(FeedPost post);

}
