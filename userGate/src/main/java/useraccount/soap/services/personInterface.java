package useraccount.soap.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.Name;
import org.springframework.ldap.core.LdapTemplate;

@WebService
public interface personInterface {
	@WebMethod
	public  void createPerson(
			@WebParam(name = "newPerson")Person newPerson);
	@WebMethod
	public  List<Person> getPersons();
	@WebMethod
	public  boolean login(
			@WebParam(name = "username")String username, 
			@WebParam(name = "password")String password);
	@WebMethod
	public  Person userProfile(
			@WebParam(name = "username")String username);
	@WebMethod
	public  Person findByUsername(
			@WebParam(name = "username")String User);
	@WebMethod
	public  boolean addUserAttribute(
			@WebParam(name = "userDn")String userDn, 
			@WebParam(name = "attribute")String attribute,
			@WebParam(name = "attValue")String attValue);
	@WebMethod
	public  boolean updateUserAttribute(
			@WebParam(name = "username") String user,
			@WebParam(name = "username") String attributename,
			@WebParam(name = "username") String newValue);
	@WebMethod
	public  String findRole();
	@WebMethod
	public  List<userRoles> personRoles(
			@WebParam(name = "username") String username);
	// END OF WEB SERVICES
	public  List<Person> findSomeone(String surname);

	public  void updateUser(Person p);

	//public  Name makeDN(String full_name);

	public  void migrateUser(Person p, String ou);

	public  List getOrgUnit();

	public  List getOrgs();

	public  String getGroupDNfrom(String groupName);

	public  String addUserToGroup(Person prsn, String group);

	public  List<groups> userGroup();

	public  List<userRoles> getRoles();

	public  String getRoleByName(String roleName);

	public  void assignRole(Person psn, String groupDN);

	public  void removeRole(Person psn, String groupDN);

}
