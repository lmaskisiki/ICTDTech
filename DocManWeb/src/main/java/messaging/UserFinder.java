package messaging;

import javax.annotation.Resource;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;



@SessionScoped
public class UserFinder {

	@Inject
	private JMSContext context;
	
	@Resource(mappedName="java:/jms/queue/SearchRequest")
	private Queue requestQ;
	
}
