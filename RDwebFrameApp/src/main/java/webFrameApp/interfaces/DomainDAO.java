package webFrameApp.interfaces;

import java.util.List;

import javax.jws.WebService;

import org.jboss.ws.api.annotation.WebContext;

import webFrameApp.entites.Domain;

@WebService
public interface DomainDAO {

	public void createDomain(String creator, String dominName, String category,
			String domainOrg, String contact, String description);
	public boolean updateDomain();
	public boolean login(String u, String p);
	public boolean purgeDomain(Domain dom);
	public List<Domain> getAllDomains();
	public List<Domain> findByCategory(String category);
	public Domain findDomain(String Name);
	public List<Domain> findByCreator(String creator);

}
