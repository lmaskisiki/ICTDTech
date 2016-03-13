package webFrameApp.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

@Component
public class authoritiesPopulator implements LdapAuthoritiesPopulator {
	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(
			DirContextOperations userData, String username) {
		Collection<GrantedAuthority> gas = new HashSet<GrantedAuthority>();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/security-context.xml");
		BeanFactory factory = context;
		personInterface userService = (personInterface) factory.getBean("ldapUser");
		List<userRoles> roles = userService.personRoles(username);
		for (userRoles role : roles) {
			gas.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
		}
		return gas;
	}
}
