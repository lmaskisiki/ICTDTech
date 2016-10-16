package webFrameApp.interfaces;

import java.util.List;

import javax.jws.WebService;
  


import webFrameApp.entites.Domain;
import webframe.sys.SystemMessage;

@WebService
public interface DomainDAO {

	public SystemMessage createDomain(Domain domain);
	public boolean updateDomain();
	public boolean login(String u, String p);
	public boolean purgeDomain(Domain dom);
	public List<Domain> getAllDomains();
	public List<Domain> findByCategory(String category);
	public Domain findDomain(String Name);
	public List<Domain> findByCreator(String creator);

}
