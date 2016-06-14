package useraccount.soap.services;

import java.util.List;

import javax.jws.WebService;


@WebService
public interface personInterface {
	public void createPerson(person p);
	public List<userRoles> personRoles(String username);
	public List<userRoles> getRoles();
	public person findByUsername(String User);
	public boolean login(String username, String password);
	public List<person> getPersons();
	public void assignRole(person psn,  String groupDN);
	public List<person> findSomeone(String surname);
	public void updateUser(person p);
	public person userProfile(String username);
	public boolean addUserAttribute(String userDn,String attribute,String attValue);
	public void migrateUser(person p, String ou);
	public List getOrgUnit();

	public List getOrgs();

	public String addUserToGroup(person prsn, String group);

	public List<groups> userGroup();

	public String findRole();
 
	String getGroupDNfrom(String groupName);
	void removeRole(person psn, String groupDN);
	String getRoleByName(String roleName);
}
