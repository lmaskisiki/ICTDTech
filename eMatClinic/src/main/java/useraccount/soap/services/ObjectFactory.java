
package useraccount.soap.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the useraccount.soap.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddUserAttributeResponse_QNAME = new QName("http://services.soap.useraccount/", "addUserAttributeResponse");
    private final static QName _UpdateUser_QNAME = new QName("http://services.soap.useraccount/", "updateUser");
    private final static QName _FindRoleResponse_QNAME = new QName("http://services.soap.useraccount/", "findRoleResponse");
    private final static QName _GetRoleByName_QNAME = new QName("http://services.soap.useraccount/", "getRoleByName");
    private final static QName _GetGroupDNfromResponse_QNAME = new QName("http://services.soap.useraccount/", "getGroupDNfromResponse");
    private final static QName _GetRolesResponse_QNAME = new QName("http://services.soap.useraccount/", "getRolesResponse");
    private final static QName _UserGroup_QNAME = new QName("http://services.soap.useraccount/", "userGroup");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://services.soap.useraccount/", "getPersonsResponse");
    private final static QName _PersonRoles_QNAME = new QName("http://services.soap.useraccount/", "personRoles");
    private final static QName _GetOrgsResponse_QNAME = new QName("http://services.soap.useraccount/", "getOrgsResponse");
    private final static QName _AssignRoleResponse_QNAME = new QName("http://services.soap.useraccount/", "assignRoleResponse");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://services.soap.useraccount/", "updateUserResponse");
    private final static QName _GetRoles_QNAME = new QName("http://services.soap.useraccount/", "getRoles");
    private final static QName _AddUserAttribute_QNAME = new QName("http://services.soap.useraccount/", "addUserAttribute");
    private final static QName _UserGroupResponse_QNAME = new QName("http://services.soap.useraccount/", "userGroupResponse");
    private final static QName _FindRole_QNAME = new QName("http://services.soap.useraccount/", "findRole");
    private final static QName _FindUserByFullNameResponse_QNAME = new QName("http://services.soap.useraccount/", "findUserByFullNameResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://services.soap.useraccount/", "loginResponse");
    private final static QName _MigrateUserResponse_QNAME = new QName("http://services.soap.useraccount/", "migrateUserResponse");
    private final static QName _FindSomeoneResponse_QNAME = new QName("http://services.soap.useraccount/", "findSomeoneResponse");
    private final static QName _MigrateUser_QNAME = new QName("http://services.soap.useraccount/", "migrateUser");
    private final static QName _RemoveRoleResponse_QNAME = new QName("http://services.soap.useraccount/", "removeRoleResponse");
    private final static QName _UserProfile_QNAME = new QName("http://services.soap.useraccount/", "userProfile");
    private final static QName _AddUserToGroup_QNAME = new QName("http://services.soap.useraccount/", "addUserToGroup");
    private final static QName _GetOrgUnit_QNAME = new QName("http://services.soap.useraccount/", "getOrgUnit");
    private final static QName _GetOrgUnitResponse_QNAME = new QName("http://services.soap.useraccount/", "getOrgUnitResponse");
    private final static QName _CreatePersonResponse_QNAME = new QName("http://services.soap.useraccount/", "createPersonResponse");
    private final static QName _Login_QNAME = new QName("http://services.soap.useraccount/", "login");
    private final static QName _CreatePerson_QNAME = new QName("http://services.soap.useraccount/", "createPerson");
    private final static QName _PersonRolesResponse_QNAME = new QName("http://services.soap.useraccount/", "personRolesResponse");
    private final static QName _AddUserToGroupResponse_QNAME = new QName("http://services.soap.useraccount/", "addUserToGroupResponse");
    private final static QName _RemoveRole_QNAME = new QName("http://services.soap.useraccount/", "removeRole");
    private final static QName _GetOrgs_QNAME = new QName("http://services.soap.useraccount/", "getOrgs");
    private final static QName _FindSomeone_QNAME = new QName("http://services.soap.useraccount/", "findSomeone");
    private final static QName _GetGroupDNfrom_QNAME = new QName("http://services.soap.useraccount/", "getGroupDNfrom");
    private final static QName _UpdateUserAttributeResponse_QNAME = new QName("http://services.soap.useraccount/", "updateUserAttributeResponse");
    private final static QName _UpdateUserAttribute_QNAME = new QName("http://services.soap.useraccount/", "updateUserAttribute");
    private final static QName _FindByUsername_QNAME = new QName("http://services.soap.useraccount/", "findByUsername");
    private final static QName _FindUserByFullName_QNAME = new QName("http://services.soap.useraccount/", "findUserByFullName");
    private final static QName _FindByUsernameResponse_QNAME = new QName("http://services.soap.useraccount/", "findByUsernameResponse");
    private final static QName _AssignRole_QNAME = new QName("http://services.soap.useraccount/", "assignRole");
    private final static QName _GetPersons_QNAME = new QName("http://services.soap.useraccount/", "getPersons");
    private final static QName _GetRoleByNameResponse_QNAME = new QName("http://services.soap.useraccount/", "getRoleByNameResponse");
    private final static QName _Person_QNAME = new QName("http://services.soap.useraccount/", "person");
    private final static QName _UserProfileResponse_QNAME = new QName("http://services.soap.useraccount/", "userProfileResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: useraccount.soap.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetGroupDNfrom }
     * 
     */
    public GetGroupDNfrom createGetGroupDNfrom() {
        return new GetGroupDNfrom();
    }

    /**
     * Create an instance of {@link AddUserAttribute }
     * 
     */
    public AddUserAttribute createAddUserAttribute() {
        return new AddUserAttribute();
    }

    /**
     * Create an instance of {@link GetRolesResponse }
     * 
     */
    public GetRolesResponse createGetRolesResponse() {
        return new GetRolesResponse();
    }

    /**
     * Create an instance of {@link UserGroupResponse }
     * 
     */
    public UserGroupResponse createUserGroupResponse() {
        return new UserGroupResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link FindSomeone }
     * 
     */
    public FindSomeone createFindSomeone() {
        return new FindSomeone();
    }

    /**
     * Create an instance of {@link MigrateUser }
     * 
     */
    public MigrateUser createMigrateUser() {
        return new MigrateUser();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link FindUserByFullNameResponse }
     * 
     */
    public FindUserByFullNameResponse createFindUserByFullNameResponse() {
        return new FindUserByFullNameResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link PersonRoles }
     * 
     */
    public PersonRoles createPersonRoles() {
        return new PersonRoles();
    }

    /**
     * Create an instance of {@link AssignRoleResponse }
     * 
     */
    public AssignRoleResponse createAssignRoleResponse() {
        return new AssignRoleResponse();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link FindUserByFullName }
     * 
     */
    public FindUserByFullName createFindUserByFullName() {
        return new FindUserByFullName();
    }

    /**
     * Create an instance of {@link MigrateUserResponse }
     * 
     */
    public MigrateUserResponse createMigrateUserResponse() {
        return new MigrateUserResponse();
    }

    /**
     * Create an instance of {@link FindSomeoneResponse }
     * 
     */
    public FindSomeoneResponse createFindSomeoneResponse() {
        return new FindSomeoneResponse();
    }

    /**
     * Create an instance of {@link UpdateUserAttribute }
     * 
     */
    public UpdateUserAttribute createUpdateUserAttribute() {
        return new UpdateUserAttribute();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link CreatePerson }
     * 
     */
    public CreatePerson createCreatePerson() {
        return new CreatePerson();
    }

    /**
     * Create an instance of {@link GetOrgUnit }
     * 
     */
    public GetOrgUnit createGetOrgUnit() {
        return new GetOrgUnit();
    }

    /**
     * Create an instance of {@link UserGroup }
     * 
     */
    public UserGroup createUserGroup() {
        return new UserGroup();
    }

    /**
     * Create an instance of {@link FindByUsername }
     * 
     */
    public FindByUsername createFindByUsername() {
        return new FindByUsername();
    }

    /**
     * Create an instance of {@link RemoveRoleResponse }
     * 
     */
    public RemoveRoleResponse createRemoveRoleResponse() {
        return new RemoveRoleResponse();
    }

    /**
     * Create an instance of {@link FindByUsernameResponse }
     * 
     */
    public FindByUsernameResponse createFindByUsernameResponse() {
        return new FindByUsernameResponse();
    }

    /**
     * Create an instance of {@link FindRoleResponse }
     * 
     */
    public FindRoleResponse createFindRoleResponse() {
        return new FindRoleResponse();
    }

    /**
     * Create an instance of {@link UpdateUserAttributeResponse }
     * 
     */
    public UpdateUserAttributeResponse createUpdateUserAttributeResponse() {
        return new UpdateUserAttributeResponse();
    }

    /**
     * Create an instance of {@link GetOrgUnitResponse }
     * 
     */
    public GetOrgUnitResponse createGetOrgUnitResponse() {
        return new GetOrgUnitResponse();
    }

    /**
     * Create an instance of {@link UserRoles }
     * 
     */
    public UserRoles createUserRoles() {
        return new UserRoles();
    }

    /**
     * Create an instance of {@link GetPersonsResponse }
     * 
     */
    public GetPersonsResponse createGetPersonsResponse() {
        return new GetPersonsResponse();
    }

    /**
     * Create an instance of {@link PersonRolesResponse }
     * 
     */
    public PersonRolesResponse createPersonRolesResponse() {
        return new PersonRolesResponse();
    }

    /**
     * Create an instance of {@link CreatePersonResponse }
     * 
     */
    public CreatePersonResponse createCreatePersonResponse() {
        return new CreatePersonResponse();
    }

    /**
     * Create an instance of {@link Groups }
     * 
     */
    public Groups createGroups() {
        return new Groups();
    }

    /**
     * Create an instance of {@link GetRoles }
     * 
     */
    public GetRoles createGetRoles() {
        return new GetRoles();
    }

    /**
     * Create an instance of {@link GetOrgs }
     * 
     */
    public GetOrgs createGetOrgs() {
        return new GetOrgs();
    }

    /**
     * Create an instance of {@link AddUserToGroup }
     * 
     */
    public AddUserToGroup createAddUserToGroup() {
        return new AddUserToGroup();
    }

    /**
     * Create an instance of {@link UserProfile }
     * 
     */
    public UserProfile createUserProfile() {
        return new UserProfile();
    }

    /**
     * Create an instance of {@link AssignRole }
     * 
     */
    public AssignRole createAssignRole() {
        return new AssignRole();
    }

    /**
     * Create an instance of {@link GetOrgsResponse }
     * 
     */
    public GetOrgsResponse createGetOrgsResponse() {
        return new GetOrgsResponse();
    }

    /**
     * Create an instance of {@link FindRole }
     * 
     */
    public FindRole createFindRole() {
        return new FindRole();
    }

    /**
     * Create an instance of {@link GetRoleByName }
     * 
     */
    public GetRoleByName createGetRoleByName() {
        return new GetRoleByName();
    }

    /**
     * Create an instance of {@link GetRoleByNameResponse }
     * 
     */
    public GetRoleByNameResponse createGetRoleByNameResponse() {
        return new GetRoleByNameResponse();
    }

    /**
     * Create an instance of {@link UserProfileResponse }
     * 
     */
    public UserProfileResponse createUserProfileResponse() {
        return new UserProfileResponse();
    }

    /**
     * Create an instance of {@link GetGroupDNfromResponse }
     * 
     */
    public GetGroupDNfromResponse createGetGroupDNfromResponse() {
        return new GetGroupDNfromResponse();
    }

    /**
     * Create an instance of {@link GetPersons }
     * 
     */
    public GetPersons createGetPersons() {
        return new GetPersons();
    }

    /**
     * Create an instance of {@link RemoveRole }
     * 
     */
    public RemoveRole createRemoveRole() {
        return new RemoveRole();
    }

    /**
     * Create an instance of {@link AddUserToGroupResponse }
     * 
     */
    public AddUserToGroupResponse createAddUserToGroupResponse() {
        return new AddUserToGroupResponse();
    }

    /**
     * Create an instance of {@link AddUserAttributeResponse }
     * 
     */
    public AddUserAttributeResponse createAddUserAttributeResponse() {
        return new AddUserAttributeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserAttributeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "addUserAttributeResponse")
    public JAXBElement<AddUserAttributeResponse> createAddUserAttributeResponse(AddUserAttributeResponse value) {
        return new JAXBElement<AddUserAttributeResponse>(_AddUserAttributeResponse_QNAME, AddUserAttributeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRoleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "findRoleResponse")
    public JAXBElement<FindRoleResponse> createFindRoleResponse(FindRoleResponse value) {
        return new JAXBElement<FindRoleResponse>(_FindRoleResponse_QNAME, FindRoleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoleByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getRoleByName")
    public JAXBElement<GetRoleByName> createGetRoleByName(GetRoleByName value) {
        return new JAXBElement<GetRoleByName>(_GetRoleByName_QNAME, GetRoleByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGroupDNfromResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getGroupDNfromResponse")
    public JAXBElement<GetGroupDNfromResponse> createGetGroupDNfromResponse(GetGroupDNfromResponse value) {
        return new JAXBElement<GetGroupDNfromResponse>(_GetGroupDNfromResponse_QNAME, GetGroupDNfromResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRolesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getRolesResponse")
    public JAXBElement<GetRolesResponse> createGetRolesResponse(GetRolesResponse value) {
        return new JAXBElement<GetRolesResponse>(_GetRolesResponse_QNAME, GetRolesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "userGroup")
    public JAXBElement<UserGroup> createUserGroup(UserGroup value) {
        return new JAXBElement<UserGroup>(_UserGroup_QNAME, UserGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonRoles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "personRoles")
    public JAXBElement<PersonRoles> createPersonRoles(PersonRoles value) {
        return new JAXBElement<PersonRoles>(_PersonRoles_QNAME, PersonRoles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrgsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getOrgsResponse")
    public JAXBElement<GetOrgsResponse> createGetOrgsResponse(GetOrgsResponse value) {
        return new JAXBElement<GetOrgsResponse>(_GetOrgsResponse_QNAME, GetOrgsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignRoleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "assignRoleResponse")
    public JAXBElement<AssignRoleResponse> createAssignRoleResponse(AssignRoleResponse value) {
        return new JAXBElement<AssignRoleResponse>(_AssignRoleResponse_QNAME, AssignRoleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getRoles")
    public JAXBElement<GetRoles> createGetRoles(GetRoles value) {
        return new JAXBElement<GetRoles>(_GetRoles_QNAME, GetRoles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserAttribute }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "addUserAttribute")
    public JAXBElement<AddUserAttribute> createAddUserAttribute(AddUserAttribute value) {
        return new JAXBElement<AddUserAttribute>(_AddUserAttribute_QNAME, AddUserAttribute.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGroupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "userGroupResponse")
    public JAXBElement<UserGroupResponse> createUserGroupResponse(UserGroupResponse value) {
        return new JAXBElement<UserGroupResponse>(_UserGroupResponse_QNAME, UserGroupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "findRole")
    public JAXBElement<FindRole> createFindRole(FindRole value) {
        return new JAXBElement<FindRole>(_FindRole_QNAME, FindRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByFullNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "findUserByFullNameResponse")
    public JAXBElement<FindUserByFullNameResponse> createFindUserByFullNameResponse(FindUserByFullNameResponse value) {
        return new JAXBElement<FindUserByFullNameResponse>(_FindUserByFullNameResponse_QNAME, FindUserByFullNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MigrateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "migrateUserResponse")
    public JAXBElement<MigrateUserResponse> createMigrateUserResponse(MigrateUserResponse value) {
        return new JAXBElement<MigrateUserResponse>(_MigrateUserResponse_QNAME, MigrateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSomeoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "findSomeoneResponse")
    public JAXBElement<FindSomeoneResponse> createFindSomeoneResponse(FindSomeoneResponse value) {
        return new JAXBElement<FindSomeoneResponse>(_FindSomeoneResponse_QNAME, FindSomeoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MigrateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "migrateUser")
    public JAXBElement<MigrateUser> createMigrateUser(MigrateUser value) {
        return new JAXBElement<MigrateUser>(_MigrateUser_QNAME, MigrateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRoleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "removeRoleResponse")
    public JAXBElement<RemoveRoleResponse> createRemoveRoleResponse(RemoveRoleResponse value) {
        return new JAXBElement<RemoveRoleResponse>(_RemoveRoleResponse_QNAME, RemoveRoleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "userProfile")
    public JAXBElement<UserProfile> createUserProfile(UserProfile value) {
        return new JAXBElement<UserProfile>(_UserProfile_QNAME, UserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserToGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "addUserToGroup")
    public JAXBElement<AddUserToGroup> createAddUserToGroup(AddUserToGroup value) {
        return new JAXBElement<AddUserToGroup>(_AddUserToGroup_QNAME, AddUserToGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrgUnit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getOrgUnit")
    public JAXBElement<GetOrgUnit> createGetOrgUnit(GetOrgUnit value) {
        return new JAXBElement<GetOrgUnit>(_GetOrgUnit_QNAME, GetOrgUnit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrgUnitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getOrgUnitResponse")
    public JAXBElement<GetOrgUnitResponse> createGetOrgUnitResponse(GetOrgUnitResponse value) {
        return new JAXBElement<GetOrgUnitResponse>(_GetOrgUnitResponse_QNAME, GetOrgUnitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "createPersonResponse")
    public JAXBElement<CreatePersonResponse> createCreatePersonResponse(CreatePersonResponse value) {
        return new JAXBElement<CreatePersonResponse>(_CreatePersonResponse_QNAME, CreatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "createPerson")
    public JAXBElement<CreatePerson> createCreatePerson(CreatePerson value) {
        return new JAXBElement<CreatePerson>(_CreatePerson_QNAME, CreatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonRolesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "personRolesResponse")
    public JAXBElement<PersonRolesResponse> createPersonRolesResponse(PersonRolesResponse value) {
        return new JAXBElement<PersonRolesResponse>(_PersonRolesResponse_QNAME, PersonRolesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserToGroupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "addUserToGroupResponse")
    public JAXBElement<AddUserToGroupResponse> createAddUserToGroupResponse(AddUserToGroupResponse value) {
        return new JAXBElement<AddUserToGroupResponse>(_AddUserToGroupResponse_QNAME, AddUserToGroupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "removeRole")
    public JAXBElement<RemoveRole> createRemoveRole(RemoveRole value) {
        return new JAXBElement<RemoveRole>(_RemoveRole_QNAME, RemoveRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrgs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getOrgs")
    public JAXBElement<GetOrgs> createGetOrgs(GetOrgs value) {
        return new JAXBElement<GetOrgs>(_GetOrgs_QNAME, GetOrgs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSomeone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "findSomeone")
    public JAXBElement<FindSomeone> createFindSomeone(FindSomeone value) {
        return new JAXBElement<FindSomeone>(_FindSomeone_QNAME, FindSomeone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGroupDNfrom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getGroupDNfrom")
    public JAXBElement<GetGroupDNfrom> createGetGroupDNfrom(GetGroupDNfrom value) {
        return new JAXBElement<GetGroupDNfrom>(_GetGroupDNfrom_QNAME, GetGroupDNfrom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserAttributeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "updateUserAttributeResponse")
    public JAXBElement<UpdateUserAttributeResponse> createUpdateUserAttributeResponse(UpdateUserAttributeResponse value) {
        return new JAXBElement<UpdateUserAttributeResponse>(_UpdateUserAttributeResponse_QNAME, UpdateUserAttributeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserAttribute }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "updateUserAttribute")
    public JAXBElement<UpdateUserAttribute> createUpdateUserAttribute(UpdateUserAttribute value) {
        return new JAXBElement<UpdateUserAttribute>(_UpdateUserAttribute_QNAME, UpdateUserAttribute.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "findByUsername")
    public JAXBElement<FindByUsername> createFindByUsername(FindByUsername value) {
        return new JAXBElement<FindByUsername>(_FindByUsername_QNAME, FindByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByFullName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "findUserByFullName")
    public JAXBElement<FindUserByFullName> createFindUserByFullName(FindUserByFullName value) {
        return new JAXBElement<FindUserByFullName>(_FindUserByFullName_QNAME, FindUserByFullName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "findByUsernameResponse")
    public JAXBElement<FindByUsernameResponse> createFindByUsernameResponse(FindByUsernameResponse value) {
        return new JAXBElement<FindByUsernameResponse>(_FindByUsernameResponse_QNAME, FindByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "assignRole")
    public JAXBElement<AssignRole> createAssignRole(AssignRole value) {
        return new JAXBElement<AssignRole>(_AssignRole_QNAME, AssignRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getPersons")
    public JAXBElement<GetPersons> createGetPersons(GetPersons value) {
        return new JAXBElement<GetPersons>(_GetPersons_QNAME, GetPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoleByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "getRoleByNameResponse")
    public JAXBElement<GetRoleByNameResponse> createGetRoleByNameResponse(GetRoleByNameResponse value) {
        return new JAXBElement<GetRoleByNameResponse>(_GetRoleByNameResponse_QNAME, GetRoleByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserProfileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap.useraccount/", name = "userProfileResponse")
    public JAXBElement<UserProfileResponse> createUserProfileResponse(UserProfileResponse value) {
        return new JAXBElement<UserProfileResponse>(_UserProfileResponse_QNAME, UserProfileResponse.class, null, value);
    }

}
