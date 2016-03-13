package webFrameApp.repositories;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webFrameApp.entites.Domain;
import webFrameApp.entites.FeedComment;

@Repository
public interface FeedCommentRepo  extends JpaRepository<FeedComment,Integer>{

 
}
