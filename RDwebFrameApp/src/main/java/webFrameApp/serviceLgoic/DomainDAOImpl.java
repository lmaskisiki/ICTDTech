package webFrameApp.serviceLgoic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import webFrameApp.entites.Domain;
import webFrameApp.interfaces.DomainDAO;
import webFrameApp.jdbcTemplate.DomainJDBC;
import webFrameApp.repositories.DomainRepo;
import webframe.sys.SystemMessage;

@WebService(endpointInterface = "webFrameApp.interfaces.DomainDAO", name = "DomainService", serviceName = "DomainService", portName = "SOAPOverHTTP")
@Service
public class DomainDAOImpl extends SpringBeanAutowiringSupport implements
		DomainDAO {
	@Autowired
	private DomainRepo repository;
	@Autowired
	private DBCreator damainCreator;

	public DomainRepo getRepository() {
		return repository;
	}

	public void setRepository(DomainRepo repository) {
		this.repository = repository;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/*
	 * ApplicationContext context = new ClassPathXmlApplicationContext(
	 * "classpath:META-INF/applicationContext.xml"); DomainJDBC
	 * webFrameApp.jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
	 * JdbcTemplate jdbc = new
	 * JdbcTemplate(webFrameApp.jdbcTemplate.getDataSource());
	 * 
	 * 
	 * @Override public boolean updateDomain() { // TODO Auto-generated method
	 * stub return false; }
	 */
	@Override
	public List<Domain> getAllDomains() {

		System.out.println("shit happens");

		return repository.findAll();

	}

	@Override
	public Domain findDomain(String name) {
		Domain dmain = null;
		List<Domain> Domains = repository.findAll();

		for (Domain dmn : Domains) {

			if (dmn.getDomainName().equals(name)) {
				dmain = dmn;

			}
		}
		return dmain;
	}

	@Override
	public SystemMessage createDomain(Domain domain) {
		return damainCreator.create(domain);
	}

	/**/

	@Override
	public boolean purgeDomain(Domain dom) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
		JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());
		String DBname = dom.getDomainName() + "_db";
		String sqlDrop = "DROP DATABASE " + DBname;
		jdbc.update(sqlDrop);
		repository.delete(dom);

		return false;
	}

	@Override
	public boolean updateDomain() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Domain> findByCreator(String creator) {
		List<Domain> all = repository.findAll();
		List<Domain> found = new ArrayList<Domain>();
		for (Domain d : all) {
			if (d.getCreator().equals(creator)) {
				found.add(d);
			}
		}
		return found;
	}

	@Override
	public boolean login(String u, String p) {
		if (u.equals("admin") && p.equals("lizo@200903375")) {

			return true;
		} else
			return false;
	}

	@Override
	public List<Domain> findByCategory(String category) {
		List<Domain> all = repository.findAll();
		List<Domain> found = new ArrayList<Domain>();
		for (Domain d : all) {
			if (d.getCategory() != null) {
				if (d.getCategory().equals(category)) {
					found.add(d);
				}
			}

		}
		return found;
	}
}
