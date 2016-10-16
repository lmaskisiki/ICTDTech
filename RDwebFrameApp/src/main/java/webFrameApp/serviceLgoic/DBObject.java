package webFrameApp.serviceLgoic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import webFrameApp.sqlstatements.DBCreateStatement;

public class DBObject {
	public DBObject() {
	HashMap<String, String> pp= new HashMap<String, String>();
	pp.put("Lizo", "Masikisiki");
	pp.put("Bahle", "Fata");
	pp.put("Bukhanye","Fata");
	pp.put("Lizo","Fata");
	Collection<String> vls = pp.values();
	Set<String> pps = pp.keySet();
		for(int x=0; x<pps.size();x++){
		System.out.printf("%-15s  %-15s \n", pps.toArray()[x],vls.toArray()[x]);
		}
	}
public static void main(String[] args) {
DBCreateStatement statement = new DBCreateStatement(null);
System.out.print(statement.Get());
}

}
