package webFrameApp.enumerations;

import java.util.ArrayList;
import java.util.List;

public class ListEnumerations {

	public ListEnumerations() {
		// TODO Auto-generated constructor stub
	}
	public List<EntityAccessType> ListAccessType() {
		List<EntityAccessType> list = new ArrayList<EntityAccessType>();
		for (EntityAccessType eat : EntityAccessType.values()) {
			list.add(eat);
		}
		return list;
	}

	
	
	public List<DomainCategory > ListDomainCategories() {
		List<DomainCategory > list = new ArrayList<DomainCategory >();
		for (DomainCategory  eat :DomainCategory .values()) {
			list.add(eat);
		}
		return list;
	}
	
}
