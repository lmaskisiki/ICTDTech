package webFrameApp.repositories;

 

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webFrameApp.entites.Domain;
import webFrameApp.entites.FeedPost;

@Transactional
@Repository
public interface FeedPostRepo  extends JpaRepository<FeedPost,Integer>{

 
}
