package userGate.classes;

import org.springframework.ldap.core.DistinguishedName;

public class groups {

	
	private String groupDN;
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupdn) {
		DistinguishedName dn=new DistinguishedName(groupdn);
		this.groupName=dn.getValue("cn");
		
	}

	public String getGroupDN() {
		return groupDN;
	}

	public void setGroupDN(String groupDN) {
		this.groupDN = groupDN;
	}
	
}
