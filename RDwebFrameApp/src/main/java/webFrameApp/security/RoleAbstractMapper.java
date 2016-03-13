package webFrameApp.security;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;

public class RoleAbstractMapper extends AbstractContextMapper {

	@Override
	protected Object doMapFromContext(DirContextOperations context) {
		userRoles role = new userRoles();
		Attributes att = context.getAttributes();
		String rol = "";
		try {
			rol = att.get("cn").get(0).toString();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		role.setRole(rol);

		return role;
	}

}
