package webFrameApp.security;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//@Service
//@Component
public class personDAOimpl implements personInterface {
	private LdapTemplate ldapTemp;
	private String baseDN = ",dc=myldap,dc=com";
	private static final String fullDN = "distinguishedname";
	private static final String member_attribute = "member";

	public LdapTemplate getLdapTemp() {
		return ldapTemp;
	}

	public void setLdapTemp(LdapTemplate ldapTemp) {
		this.ldapTemp = ldapTemp;
	}

	private DistinguishedName getDnFrom(String fullname) {
		DistinguishedName newContactDN = new DistinguishedName();
		newContactDN.add("cn", fullname);
		newContactDN.add("ou", "userAccounts");
		return newContactDN;
	}

	@Override
	public void createPerson(person p) {
		Attributes userAttributes = new BasicAttributes();
		userAttributes.put("objectClass", "person");
		userAttributes.put("objectClass", "inetOrgPerson");
		userAttributes.put("givenName", p.getFirst_name());
		userAttributes.put("sn", p.getLast_name());
		userAttributes.put("uid", p.getUsername());
		userAttributes.put("mobile", p.getCell());
		userAttributes.put("mail", p.getEmail());
		userAttributes.put("userPassword", p.getPassword());
		
		
		
		ldapTemp.bind(makeDN(p.getFirst_name() + " " + p.getLast_name()), null,
				userAttributes);

	}

	@Override
	public List<person> getPersons() {
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		return ldapTemp.search("", "(objectclass=person)", controls,
				new UserContextMapper());

	}

	@Override
	public List<person> findSomeone(String full_name) {

		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "inetOrgPerson")).and(
				new EqualsFilter("cn", full_name));
		List<person> users = ldapTemp.search("", filter.toString(), controls,
				new UserContextMapper());

		return users;

	}

	@Override
	public void updateUser(person p) {
		// Name dn = getDnFrom(p.getFirst_name() + " " + p.getLast_name());
		DistinguishedName dn = new DistinguishedName();

		dn.add("ou", "userAccounts");
		dn.add("cn", p.getFirst_name() + " " + p.getLast_name());
		DirContextOperations context = ldapTemp.lookupContext(dn);
		context.setAttributeValue("mobile", p.getCell());
		context.setAttributeValue("mail", p.getEmail());

		ldapTemp.modifyAttributes(context);

	}

	public Name makeDN(String full_name) {
		DistinguishedName dn = new DistinguishedName();
		dn.add("ou", "userAccounts");
		dn.add("cn", full_name);

		return dn;
	}

	@Override
	public boolean login(String username, String password) {
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "inetOrgPerson")).and(
				new EqualsFilter("uid", username));
		return ldapTemp.authenticate(DistinguishedName.EMPTY_PATH,
				filter.toString(), password);

	}

	@Override
	public person userProfile(String username) {
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "inetOrgPerson")).and(
				new EqualsFilter("uid", username));
		List<person> users = ldapTemp.search("", filter.toString(), controls,
				new UserContextMapper());
		person user = users.get(0);
		return user;
	}

	@Override
	public void migrateUser(person p, String ou) {
		// Name dn = getDnFrom(p.getFirst_name() + " " + p.getLast_name());
		DistinguishedName dn = new DistinguishedName();
		DistinguishedName dn1 = new DistinguishedName();

		dn.add("ou", "userAccounts");
		dn.add("cn", p.getFirst_name() + " " + p.getLast_name());
		DirContextOperations context = ldapTemp.lookupContext(dn);

		DirContextOperations context1 = ldapTemp.lookupContext(dn);
		context1.setAttributeValue("ou", ou);
		context1.setAttributeValue("mobile", p.getCell());
		context1.setAttributeValue("mail", p.getEmail());

		dn1.add("ou", ou);
		dn1.add("cn", dn.getValue("cn"));
		 
	}

	@Override
	public List getOrgUnit() {
		AndFilter filter = new AndFilter();

		filter.and(new EqualsFilter("objectclass", "organizationalUnit"));

		List list = ldapTemp.search("", filter.encode(),
				new AttributesMapper() {
					public Object mapFromAttributes(Attributes attrs)
							throws NamingException {
						return attrs.get("ou").get();
					}
				});

		return list;
	}

	@Override
	public List getOrgs() {
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "organization"));
		List list = ldapTemp.search("", filter.encode(),
				new AttributesMapper() {
					public Object mapFromAttributes(Attributes attrs)
							throws NamingException {
						return attrs.get("o").get();
					}
				});

		return list;
	}

	private String getUserDNfrom(person p) {
		String Full_Name = p.getFirst_name() + " " + p.getLast_name();
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		AndFilter fil = new AndFilter();
		fil.and((new EqualsFilter("objectclass", "inetOrgPerson")));
		fil.and((new EqualsFilter("cn", Full_Name)));
		List<person> list = ldapTemp.search(DistinguishedName.EMPTY_PATH,
				fil.encode(), new UserContextMapper());

		String dn = list.get(0).getDn();
		System.out.println(" dn found: " + dn);
		return dn;

	}

	@Override
	public String getGroupDNfrom(String groupName) {
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "groupOfNames")).and(
				new EqualsFilter("cn", groupName));
		List<groups> group = ldapTemp.search("", filter.toString(), controls,
				new GroupContextMapper());

		System.out.println("try get group dn");
		String groupDn = group.get(0).getGroupDN();
		System.out.println("found group dn " + groupDn);
		return groupDn;

	}

	@Override
	public String addUserToGroup(person prsn, String group) {

		String userDN = getUserDNfrom(prsn);
		String groupDN = getGroupDNfrom(group);
		if ((userDN != null || (!userDN.equals("")))
				&& (groupDN != null || (!groupDN.equals("")))) {
			DistinguishedName dn = new DistinguishedName(userDN);
			DirContextOperations ctx = ldapTemp.lookupContext(dn);
			DistinguishedName dc = new DistinguishedName(userDN + baseDN);
			ModificationItem[] mod = new ModificationItem[1];
			Attribute att = new BasicAttribute("member", dc.encode());
			mod[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, att);
			ldapTemp.modifyAttributes(groupDN, mod);

		}
		return userDN;

	}

	@Override
	public List<groups> groups() {
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "groupOfNames"));
		List<groups> group = ldapTemp.search("", filter.toString(), controls,
				new GroupContextMapper());
		return group;

	}

	@Override
	public String findRole() {

		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "groupOfUniqueNames"));
		List<groups> group = ldapTemp.search("", filter.toString(), controls,
				new GroupContextMapper());
		return group.get(0).getGroupDN();
	}

	@Override
	public List<userRoles> personRoles(String username) {
		person psn = findByUsername(username);
		String userDN = getUserDNfrom(psn);
		userDN = userDN + baseDN;
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "groupOfNames")).and(
				new EqualsFilter("member", userDN));
		List<userRoles> roles = ldapTemp.search("", filter.toString(),
				controls, new RoleAbstractMapper());

		return roles;
	}

	@Override
	public person findByUsername(String User) {

		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "inetOrgPerson")).and(
				new EqualsFilter("uid", User));
		List<person> users = ldapTemp.search("", filter.toString(), controls,
				new UserContextMapper());

		return users.get(0);

	}

}