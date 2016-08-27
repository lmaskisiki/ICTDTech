package birthcertificate.ews.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-08-16T18:55:27.509+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://soap.ews.birthcertificate/", name = "IBEService")
@XmlSeeAlso({ObjectFactory.class})
public interface IBEService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "applications", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.Applications")
    @WebMethod
    @ResponseWrapper(localName = "applicationsResponse", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.ApplicationsResponse")
    public java.util.List<birthcertificate.ews.soap.CollectionStatus> applications();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "approved", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.Approved")
    @WebMethod
    @ResponseWrapper(localName = "approvedResponse", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.ApprovedResponse")
    public java.util.List<birthcertificate.ews.soap.BCertificate> approved();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "checkStatus", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.CheckStatus")
    @WebMethod
    @ResponseWrapper(localName = "checkStatusResponse", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.CheckStatusResponse")
    public birthcertificate.ews.soap.CollectionStatus checkStatus(
        @WebParam(name = "parentId", targetNamespace = "")
        int parentId
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "BatchApplication", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.BatchApplication")
    @WebMethod(operationName = "BatchApplication")
    @ResponseWrapper(localName = "BatchApplicationResponse", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.BatchApplicationResponse")
    public birthcertificate.ews.soap.SystemMessage batchApplication(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createApplication", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.CreateApplication")
    @WebMethod
    @ResponseWrapper(localName = "createApplicationResponse", targetNamespace = "http://soap.ews.birthcertificate/", className = "birthcertificate.ews.soap.CreateApplicationResponse")
    public birthcertificate.ews.soap.SystemMessage createApplication(
        @WebParam(name = "labour", targetNamespace = "")
        birthcertificate.ews.soap.Labour labour
    );
}
