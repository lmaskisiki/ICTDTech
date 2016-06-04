package webFrameApp.repositories;

 



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import webFrameApp.entites.FeedPost;

 @Repository
public interface FeedPostRepo   extends JpaRepository<FeedPost,Integer>{

 
}
