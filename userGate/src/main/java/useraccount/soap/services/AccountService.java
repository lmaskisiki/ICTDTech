package useraccount.soap.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.Name;
import javax.ws.rs.Produces;

import org.springframework.ldap.core.LdapTemplate;

public interface AccountService {

	public abstract void createPerson(Person newPerson);

	public abstract List<Person> getPersons();

	public abstract boolean login(String username, String password);

	public abstract Person userProfile(String username);

	public abstract Person findByUsername(String User);

	public abstract boolean addUserAttribute(String userDn, String attribute,
			String attValue);

	public abstract boolean updateUserAttribute(String user,
			String attributename, String newValue);
	// public abstract List<userRoles> personRoles(String username);

	// public abstract List<Person> findSomeone(String surname);

	// public abstract void updateUser(Person p);

	// public abstract Name makeDN(String full_name);

	// public abstract void migrateUser(Person p, String ou);

	// /public abstract List getOrgUnit();

	// /public abstract List getOrgs();
	//
	// public abstract String getGroupDNfrom(String groupName);

	// public abstract String addUserToGroup(Person prsn, String group);

	// public abstract List<groups> userGroup();

	// public abstract String findRole();

	// public abstract List<userRoles> getRoles();

	// public abstract String getRoleByName(String roleName);

	// public abstract void assignRole(Person psn, String groupDN);

	// /public abstract void removeRole(Person psn, String groupDN);

}