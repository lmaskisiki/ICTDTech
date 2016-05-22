
package webframeapp.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webframeapp.interfaces package. 
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

    private final static QName _NewRelationshipResponse_QNAME = new QName("http://interfaces.webFrameApp/", "newRelationshipResponse");
    private final static QName _FindAllResponse_QNAME = new QName("http://interfaces.webFrameApp/", "findAllResponse");
    private final static QName _CreateEntityResponse_QNAME = new QName("http://interfaces.webFrameApp/", "CreateEntityResponse");
    private final static QName _Delete_QNAME = new QName("http://interfaces.webFrameApp/", "delete");
    private final static QName _FindByDomain_QNAME = new QName("http://interfaces.webFrameApp/", "findByDomain");
    private final static QName _FindByNameResponse_QNAME = new QName("http://interfaces.webFrameApp/", "findByNameResponse");
    private final static QName _FindByDomainResponse_QNAME = new QName("http://interfaces.webFrameApp/", "findByDomainResponse");
    private final static QName _FindByName_QNAME = new QName("http://interfaces.webFrameApp/", "findByName");
    private final static QName _DeleteResponse_QNAME = new QName("http://interfaces.webFrameApp/", "deleteResponse");
    private final static QName _RelateEntities_QNAME = new QName("http://interfaces.webFrameApp/", "relateEntities");
    private final static QName _RelateEntitiesResponse_QNAME = new QName("http://interfaces.webFrameApp/", "relateEntitiesResponse");
    private final static QName _CreateEntity_QNAME = new QName("http://interfaces.webFrameApp/", "CreateEntity");
    private final static QName _FindAll_QNAME = new QName("http://interfaces.webFrameApp/", "findAll");
    private final static QName _NewRelationship_QNAME = new QName("http://interfaces.webFrameApp/", "newRelationship");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webframeapp.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link NewRelationshipResponse }
     * 
     */
    public NewRelationshipResponse createNewRelationshipResponse() {
        return new NewRelationshipResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link NewRelationship }
     * 
     */
    public NewRelationship createNewRelationship() {
        return new NewRelationship();
    }

    /**
     * Create an instance of {@link Domain }
     * 
     */
    public Domain createDomain() {
        return new Domain();
    }

    /**
     * Create an instance of {@link FindByNameResponse }
     * 
     */
    public FindByNameResponse createFindByNameResponse() {
        return new FindByNameResponse();
    }

    /**
     * Create an instance of {@link FindByName }
     * 
     */
    public FindByName createFindByName() {
        return new FindByName();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindByDomain }
     * 
     */
    public FindByDomain createFindByDomain() {
        return new FindByDomain();
    }

    /**
     * Create an instance of {@link CreateEntityResponse }
     * 
     */
    public CreateEntityResponse createCreateEntityResponse() {
        return new CreateEntityResponse();
    }

    /**
     * Create an instance of {@link SqldataTypes }
     * 
     */
    public SqldataTypes createSqldataTypes() {
        return new SqldataTypes();
    }

    /**
     * Create an instance of {@link OrgEntity }
     * 
     */
    public OrgEntity createOrgEntity() {
        return new OrgEntity();
    }

    /**
     * Create an instance of {@link FindByDomainResponse }
     * 
     */
    public FindByDomainResponse createFindByDomainResponse() {
        return new FindByDomainResponse();
    }

    /**
     * Create an instance of {@link RelateEntitiesResponse }
     * 
     */
    public RelateEntitiesResponse createRelateEntitiesResponse() {
        return new RelateEntitiesResponse();
    }

    /**
     * Create an instance of {@link RelateEntities }
     * 
     */
    public RelateEntities createRelateEntities() {
        return new RelateEntities();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link CreateEntity }
     * 
     */
    public CreateEntity createCreateEntity() {
        return new CreateEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewRelationshipResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "newRelationshipResponse")
    public JAXBElement<NewRelationshipResponse> createNewRelationshipResponse(NewRelationshipResponse value) {
        return new JAXBElement<NewRelationshipResponse>(_NewRelationshipResponse_QNAME, NewRelationshipResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "CreateEntityResponse")
    public JAXBElement<CreateEntityResponse> createCreateEntityResponse(CreateEntityResponse value) {
        return new JAXBElement<CreateEntityResponse>(_CreateEntityResponse_QNAME, CreateEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByDomain }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "findByDomain")
    public JAXBElement<FindByDomain> createFindByDomain(FindByDomain value) {
        return new JAXBElement<FindByDomain>(_FindByDomain_QNAME, FindByDomain.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "findByNameResponse")
    public JAXBElement<FindByNameResponse> createFindByNameResponse(FindByNameResponse value) {
        return new JAXBElement<FindByNameResponse>(_FindByNameResponse_QNAME, FindByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByDomainResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "findByDomainResponse")
    public JAXBElement<FindByDomainResponse> createFindByDomainResponse(FindByDomainResponse value) {
        return new JAXBElement<FindByDomainResponse>(_FindByDomainResponse_QNAME, FindByDomainResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "findByName")
    public JAXBElement<FindByName> createFindByName(FindByName value) {
        return new JAXBElement<FindByName>(_FindByName_QNAME, FindByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelateEntities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "relateEntities")
    public JAXBElement<RelateEntities> createRelateEntities(RelateEntities value) {
        return new JAXBElement<RelateEntities>(_RelateEntities_QNAME, RelateEntities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelateEntitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "relateEntitiesResponse")
    public JAXBElement<RelateEntitiesResponse> createRelateEntitiesResponse(RelateEntitiesResponse value) {
        return new JAXBElement<RelateEntitiesResponse>(_RelateEntitiesResponse_QNAME, RelateEntitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "CreateEntity")
    public JAXBElement<CreateEntity> createCreateEntity(CreateEntity value) {
        return new JAXBElement<CreateEntity>(_CreateEntity_QNAME, CreateEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewRelationship }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "newRelationship")
    public JAXBElement<NewRelationship> createNewRelationship(NewRelationship value) {
        return new JAXBElement<NewRelationship>(_NewRelationship_QNAME, NewRelationship.class, null, value);
    }

}
