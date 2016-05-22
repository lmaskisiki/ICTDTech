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

@WebService(endpointInterface = "webFrameApp.interfaces.DomainDAO",name="DomainService",serviceName="DomainService", portName= "SOAPOverHTTP"
)
@Service
public class DomainDAOImpl extends SpringBeanAutowiringSupport implements
		DomainDAO {
	@Autowired
	private DomainRepo repository;

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
	public void createDomain(String creator, String dominName, String category,
			String domainOrg, String contact, String description) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		//get jdbc connection, setup jdbctemplate from springs' app context
		DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
		JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());
		Domain domain = new Domain();
		//setup domain properties
		domain.setCreator(creator);
		domain.setDomainName(dominName);
		domain.setOrgName(domainOrg);
		domain.setContactDetails(contact);
		domain.setDescription(description);
		domain.setCategory(category);
		//register the domain, then create a database for  it
		Domain createdDomain = repository.save(domain);
		System.out.println("Doamin Saved partially saved, create DB below...");
		if (createdDomain != null) {
			String domainDB = createdDomain.getDomainName() + "_db";
			String createDB = "CREATE DATABASE IF NOT EXISTS \t " + domainDB;
			int x = jdbc.update(createDB);
			System.out.println("Domain creation success!!! :(");

		}
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
			if(d.getCategory() !=null){
								if (d.getCategory().equals(category)) {
					found.add(d);
				}
			}
			
		}
		return found;
	}
}
