import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webFrameApp.entites.Domain;
import webFrameApp.entites.FeedComment;
import webFrameApp.entites.FeedPost;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.FeedPostImpl;
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/applicationContext.xml"})
public class feedTest  {
	 @Autowired
	 private FeedPostImpl service;
	 @Autowired
	 private DomainDAOImpl domain;
	@Test
	@Transactional
	public void testPost(){
	 Domain d= new Domain();
	 d.setDomainName("newDN");
			//domain.createDomain(null, "newDB2",null, null,null, null);
 	}


}
