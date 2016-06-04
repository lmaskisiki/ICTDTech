package infosource.open.services.access;

import useraccount.soap.services.Person;



public interface ITransactionManager {
 
public	boolean createAccount(Person person);
public String getNews();
String fullProfile(String username);
public String getHealthInfo();
public String getHomeAffairInfo();
 String getMyProfile(String username);
String getMyDocuments(String username);
}
