package webFrameApp.serviceLgoic;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import webFrameApp.entites.FeedComment;
import webFrameApp.entites.FeedPost;
import webFrameApp.interfaces.FeedCommentDAO;
import webFrameApp.repositories.FeedCommentRepo;
 @Service
public class FeedCommentImpl extends SpringBeanAutowiringSupport implements FeedCommentDAO {
	@Autowired
	private FeedCommentRepo repo;

	@Override
	public void Addcomment(FeedPost post, FeedComment comment) {
		 
	 
		System.out.println("comments retrieved...");
		
		comment.setPost(post);
		repo.save(comment);

	}

	@Override
	public void Removecomment(FeedComment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Listcomments(FeedPost post) {
		// TODO Auto-generated method stub

	}

}
