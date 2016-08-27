
package useraccount.soap.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "personInterface", targetNamespace = "http://services.soap.useraccount/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonInterface {


    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "migrateUser", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.MigrateUser")
    @ResponseWrapper(localName = "migrateUserResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.MigrateUserResponse")
    public void migrateUser(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param username
     * @return
     *     returns useraccount.soap.services.Person
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByUsername", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.FindByUsername")
    @ResponseWrapper(localName = "findByUsernameResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.FindByUsernameResponse")
    public Person findByUsername(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.LoginResponse")
    public boolean login(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param attValue
     * @param attribute
     * @param userDn
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUserAttribute", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.AddUserAttribute")
    @ResponseWrapper(localName = "addUserAttributeResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.AddUserAttributeResponse")
    public boolean addUserAttribute(
        @WebParam(name = "userDn", targetNamespace = "")
        String userDn,
        @WebParam(name = "attribute", targetNamespace = "")
        String attribute,
        @WebParam(name = "attValue", targetNamespace = "")
        String attValue);

    /**
     * 
     * @param newPerson
     */
    @WebMethod
    @RequestWrapper(localName = "createAccount", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.CreateAccount")
    @ResponseWrapper(localName = "createAccountResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.CreateAccountResponse")
    public void createAccount(
        @WebParam(name = "newPerson", targetNamespace = "")
        Person newPerson);

    /**
     * 
     * @param fullname
     * @return
     *     returns useraccount.soap.services.Person
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findUserByFullName", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.FindUserByFullName")
    @ResponseWrapper(localName = "findUserByFullNameResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.FindUserByFullNameResponse")
    public Person findUserByFullName(
        @WebParam(name = "fullname", targetNamespace = "")
        String fullname);

    /**
     * 
     * @return
     *     returns java.util.List<useraccount.soap.services.UserRoles>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRoles", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetRoles")
    @ResponseWrapper(localName = "getRolesResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetRolesResponse")
    public List<UserRoles> getRoles();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getGroupDNfrom", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetGroupDNfrom")
    @ResponseWrapper(localName = "getGroupDNfromResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetGroupDNfromResponse")
    public String getGroupDNfrom(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.UpdateUserResponse")
    public void updateUser(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgUnit", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetOrgUnit")
    @ResponseWrapper(localName = "getOrgUnitResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetOrgUnitResponse")
    public List<Object> getOrgUnit();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRoleByName", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetRoleByName")
    @ResponseWrapper(localName = "getRoleByNameResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetRoleByNameResponse")
    public String getRoleByName(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param username
     * @return
     *     returns useraccount.soap.services.Person
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userProfile", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.UserProfile")
    @ResponseWrapper(localName = "userProfileResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.UserProfileResponse")
    public Person userProfile(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUserToGroup", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.AddUserToGroup")
    @ResponseWrapper(localName = "addUserToGroupResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.AddUserToGroupResponse")
    public String addUserToGroup(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "removeRole", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.RemoveRole")
    @ResponseWrapper(localName = "removeRoleResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.RemoveRoleResponse")
    public void removeRole(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "assignRole", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.AssignRole")
    @ResponseWrapper(localName = "assignRoleResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.AssignRoleResponse")
    public void assignRole(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @return
     *     returns java.util.List<useraccount.soap.services.Groups>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userGroup", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.UserGroup")
    @ResponseWrapper(localName = "userGroupResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.UserGroupResponse")
    public List<Groups> userGroup();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<useraccount.soap.services.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findSomeone", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.FindSomeone")
    @ResponseWrapper(localName = "findSomeoneResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.FindSomeoneResponse")
    public List<Person> findSomeone(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<useraccount.soap.services.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPersons", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetPersons")
    @ResponseWrapper(localName = "getPersonsResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetPersonsResponse")
    public List<Person> getPersons();

    /**
     * 
     * @param rolename
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isUserMemberOf", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.IsUserMemberOf")
    @ResponseWrapper(localName = "isUserMemberOfResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.IsUserMemberOfResponse")
    public boolean isUserMemberOf(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "rolename", targetNamespace = "")
        String rolename);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgs", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetOrgs")
    @ResponseWrapper(localName = "getOrgsResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.GetOrgsResponse")
    public List<Object> getOrgs();

    /**
     * 
     * @param attribute
     * @param value
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateUserAttribute", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.UpdateUserAttribute")
    @ResponseWrapper(localName = "updateUserAttributeResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.UpdateUserAttributeResponse")
    public boolean updateUserAttribute(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "attribute", targetNamespace = "")
        String attribute,
        @WebParam(name = "value", targetNamespace = "")
        String value);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findRole", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.FindRole")
    @ResponseWrapper(localName = "findRoleResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.FindRoleResponse")
    public String findRole();

    /**
     * 
     * @param username
     * @return
     *     returns java.util.List<useraccount.soap.services.UserRoles>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "personRoles", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.PersonRoles")
    @ResponseWrapper(localName = "personRolesResponse", targetNamespace = "http://services.soap.useraccount/", className = "useraccount.soap.services.PersonRolesResponse")
    public List<UserRoles> personRoles(
        @WebParam(name = "username", targetNamespace = "")
        String username);

}
