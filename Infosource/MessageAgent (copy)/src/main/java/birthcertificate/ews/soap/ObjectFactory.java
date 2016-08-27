
package birthcertificate.ews.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the birthcertificate.ews.soap package. 
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

    private final static QName _CollectionStatus_QNAME = new QName("http://soap.ews.birthcertificate/", "collectionStatus");
    private final static QName _CreateApplication_QNAME = new QName("http://soap.ews.birthcertificate/", "createApplication");
    private final static QName _Maternity_QNAME = new QName("http://soap.ews.birthcertificate/", "maternity");
    private final static QName _BatchApplication_QNAME = new QName("http://soap.ews.birthcertificate/", "BatchApplication");
    private final static QName _Approved_QNAME = new QName("http://soap.ews.birthcertificate/", "approved");
    private final static QName _CheckStatus_QNAME = new QName("http://soap.ews.birthcertificate/", "checkStatus");
    private final static QName _BatchApplicationResponse_QNAME = new QName("http://soap.ews.birthcertificate/", "BatchApplicationResponse");
    private final static QName _ApplicationsResponse_QNAME = new QName("http://soap.ews.birthcertificate/", "applicationsResponse");
    private final static QName _Applications_QNAME = new QName("http://soap.ews.birthcertificate/", "applications");
    private final static QName _BCertificate_QNAME = new QName("http://soap.ews.birthcertificate/", "bCertificate");
    private final static QName _Child_QNAME = new QName("http://soap.ews.birthcertificate/", "child");
    private final static QName _CheckStatusResponse_QNAME = new QName("http://soap.ews.birthcertificate/", "checkStatusResponse");
    private final static QName _ApprovedResponse_QNAME = new QName("http://soap.ews.birthcertificate/", "approvedResponse");
    private final static QName _SystemMessage_QNAME = new QName("http://soap.ews.birthcertificate/", "systemMessage");
    private final static QName _Labour_QNAME = new QName("http://soap.ews.birthcertificate/", "labour");
    private final static QName _CreateApplicationResponse_QNAME = new QName("http://soap.ews.birthcertificate/", "createApplicationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: birthcertificate.ews.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SystemMessage }
     * 
     */
    public SystemMessage createSystemMessage() {
        return new SystemMessage();
    }

    /**
     * Create an instance of {@link ApprovedResponse }
     * 
     */
    public ApprovedResponse createApprovedResponse() {
        return new ApprovedResponse();
    }

    /**
     * Create an instance of {@link CreateApplicationResponse }
     * 
     */
    public CreateApplicationResponse createCreateApplicationResponse() {
        return new CreateApplicationResponse();
    }

    /**
     * Create an instance of {@link Labour }
     * 
     */
    public Labour createLabour() {
        return new Labour();
    }

    /**
     * Create an instance of {@link BatchApplicationResponse }
     * 
     */
    public BatchApplicationResponse createBatchApplicationResponse() {
        return new BatchApplicationResponse();
    }

    /**
     * Create an instance of {@link ApplicationsResponse }
     * 
     */
    public ApplicationsResponse createApplicationsResponse() {
        return new ApplicationsResponse();
    }

    /**
     * Create an instance of {@link Approved }
     * 
     */
    public Approved createApproved() {
        return new Approved();
    }

    /**
     * Create an instance of {@link CheckStatus }
     * 
     */
    public CheckStatus createCheckStatus() {
        return new CheckStatus();
    }

    /**
     * Create an instance of {@link BatchApplication }
     * 
     */
    public BatchApplication createBatchApplication() {
        return new BatchApplication();
    }

    /**
     * Create an instance of {@link CollectionStatus }
     * 
     */
    public CollectionStatus createCollectionStatus() {
        return new CollectionStatus();
    }

    /**
     * Create an instance of {@link CreateApplication }
     * 
     */
    public CreateApplication createCreateApplication() {
        return new CreateApplication();
    }

    /**
     * Create an instance of {@link Maternity }
     * 
     */
    public Maternity createMaternity() {
        return new Maternity();
    }

    /**
     * Create an instance of {@link CheckStatusResponse }
     * 
     */
    public CheckStatusResponse createCheckStatusResponse() {
        return new CheckStatusResponse();
    }

    /**
     * Create an instance of {@link Applications }
     * 
     */
    public Applications createApplications() {
        return new Applications();
    }

    /**
     * Create an instance of {@link BCertificate }
     * 
     */
    public BCertificate createBCertificate() {
        return new BCertificate();
    }

    /**
     * Create an instance of {@link Child }
     * 
     */
    public Child createChild() {
        return new Child();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CollectionStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "collectionStatus")
    public JAXBElement<CollectionStatus> createCollectionStatus(CollectionStatus value) {
        return new JAXBElement<CollectionStatus>(_CollectionStatus_QNAME, CollectionStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "createApplication")
    public JAXBElement<CreateApplication> createCreateApplication(CreateApplication value) {
        return new JAXBElement<CreateApplication>(_CreateApplication_QNAME, CreateApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Maternity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "maternity")
    public JAXBElement<Maternity> createMaternity(Maternity value) {
        return new JAXBElement<Maternity>(_Maternity_QNAME, Maternity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "BatchApplication")
    public JAXBElement<BatchApplication> createBatchApplication(BatchApplication value) {
        return new JAXBElement<BatchApplication>(_BatchApplication_QNAME, BatchApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Approved }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "approved")
    public JAXBElement<Approved> createApproved(Approved value) {
        return new JAXBElement<Approved>(_Approved_QNAME, Approved.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "checkStatus")
    public JAXBElement<CheckStatus> createCheckStatus(CheckStatus value) {
        return new JAXBElement<CheckStatus>(_CheckStatus_QNAME, CheckStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchApplicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "BatchApplicationResponse")
    public JAXBElement<BatchApplicationResponse> createBatchApplicationResponse(BatchApplicationResponse value) {
        return new JAXBElement<BatchApplicationResponse>(_BatchApplicationResponse_QNAME, BatchApplicationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "applicationsResponse")
    public JAXBElement<ApplicationsResponse> createApplicationsResponse(ApplicationsResponse value) {
        return new JAXBElement<ApplicationsResponse>(_ApplicationsResponse_QNAME, ApplicationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Applications }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "applications")
    public JAXBElement<Applications> createApplications(Applications value) {
        return new JAXBElement<Applications>(_Applications_QNAME, Applications.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BCertificate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "bCertificate")
    public JAXBElement<BCertificate> createBCertificate(BCertificate value) {
        return new JAXBElement<BCertificate>(_BCertificate_QNAME, BCertificate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Child }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "child")
    public JAXBElement<Child> createChild(Child value) {
        return new JAXBElement<Child>(_Child_QNAME, Child.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "checkStatusResponse")
    public JAXBElement<CheckStatusResponse> createCheckStatusResponse(CheckStatusResponse value) {
        return new JAXBElement<CheckStatusResponse>(_CheckStatusResponse_QNAME, CheckStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "approvedResponse")
    public JAXBElement<ApprovedResponse> createApprovedResponse(ApprovedResponse value) {
        return new JAXBElement<ApprovedResponse>(_ApprovedResponse_QNAME, ApprovedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "systemMessage")
    public JAXBElement<SystemMessage> createSystemMessage(SystemMessage value) {
        return new JAXBElement<SystemMessage>(_SystemMessage_QNAME, SystemMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Labour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "labour")
    public JAXBElement<Labour> createLabour(Labour value) {
        return new JAXBElement<Labour>(_Labour_QNAME, Labour.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateApplicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ews.birthcertificate/", name = "createApplicationResponse")
    public JAXBElement<CreateApplicationResponse> createCreateApplicationResponse(CreateApplicationResponse value) {
        return new JAXBElement<CreateApplicationResponse>(_CreateApplicationResponse_QNAME, CreateApplicationResponse.class, null, value);
    }

}
