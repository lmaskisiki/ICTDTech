package userGate.classes;



import java.util.Collection;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

public class GroupContextMapper extends AbstractContextMapper   {

	@Override
	protected Object doMapFromContext(DirContextOperations context) {
	groups group=new groups();

	
	group.setGroupDN(context.getDn().toString());
	group.setGroupName(group.getGroupDN());
		

		
		return group;
	}

	

}
