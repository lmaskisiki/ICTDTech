package webFrameApp.serviceLgoic;

import java.util.HashMap;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import webFrameApp.entites.Domain;
import webFrameApp.jdbcTemplate.DomainJDBC;
import webFrameApp.repositories.DomainRepo;
import webFrameApp.sqlstatements.DBCreateStatement;
import webframe.sys.SystemMessage;

@Component
public class DBCreator {
	@Autowired
	private DomainRepo domainRepo;
	ApplicationContext cxt = null;
	final String contextPath = "classpath:META-INF/applicationContext.xml";

	public SystemMessage create(Domain domainObject) {
		SystemMessage message = new SystemMessage();
		try {
			cxt = new ClassPathXmlApplicationContext(contextPath);
			DomainJDBC jdbcTemplate = (DomainJDBC) cxt.getBean("DomainJDBC");
			JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());
			Domain createdDomain = domainRepo.save(domainObject);
			if (createdDomain != null) {
				String statement = new DBCreateStatement(
						domainObject.getDomainName()).Get();
				jdbc.execute(statement);
			}
		} catch (Exception e) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(e.getClass().getName() + "", e.getMessage() + "");
			message.setMessages(map);
			message.HasException(true);
		}
		return message;
	}
}
