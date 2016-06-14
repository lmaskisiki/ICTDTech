package useraccount.soap.services;

import java.util.ArrayList;
import java.util.List;

public class UserAttributes {

	public static boolean exists(String attribute) {
		List<String> attlist = new ArrayList<String>();
		for (userAttributes a : userAttributes.values()) {
			attlist.add(a.toString());
		}
		return attlist.contains(attribute);
	}

	enum userAttributes {
		uid, uidNumber,mobile, mail, address, state;
	}
}
