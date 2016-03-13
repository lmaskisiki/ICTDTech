package webFrameApp.security;

import java.util.List;

public interface personInterface {
	public void createPerson(person p);
	public List<userRoles> personRoles(String username);
	public person findByUsername(String User);
	public boolean login(String username, String password);
	public List<person> getPersons();
	
	

	public List<person> findSomeone(String Full_name);

	public void updateUser(person p);

	public person userProfile(String username);



	public void migrateUser(person p, String ou);


	public List getOrgUnit();

	public List getOrgs();

	public String addUserToGroup(person prsn, String group);

	public List<groups> groups();

	public String findRole();

	String getGroupDNfrom(String groupName);
}
