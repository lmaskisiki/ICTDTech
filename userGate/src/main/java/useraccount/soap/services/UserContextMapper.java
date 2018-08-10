package useraccount.soap.services;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;

public class UserContextMapper extends AbstractContextMapper {

	@Override
	protected Object doMapFromContext(DirContextOperations context) {
		Person user = new Person();

		user.setFirst_name(context.getStringAttribute("givenName"));
		user.setLast_name(context.getStringAttribute("sn"));
		user.setGender(context.getStringAttribute("title"));
		user.setCell(context.getStringAttribute("mobile"));
		user.setEmail(context.getStringAttribute("mail"));
		user.setIdNumber(context.getStringAttribute("uidNumber"));
		user.setUsername(context.getStringAttribute("uid"));
		user.setMember(context.getStringAttribute("memberOf"));
		user.setDn(context.getDn().toString());
		// user.setDn(context.getNameInNamespace().toString());
		// user.setOrgUnit(context.getStringAttribute("ou"));
		String dn = context.getDn().toString();

		if ((dn.contains("cn=")) && (dn.contains("ou="))) {
			user.setOrgUnit(context.getDn().get(0).toString());

		}

		return user;
	}

}