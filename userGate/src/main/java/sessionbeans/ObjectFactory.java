
package sessionbeans;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sessionbeans package. 
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

    private final static QName _GetSahres_QNAME = new QName("http://sessionBeans/", "getSahres");
    private final static QName _GetFilesByOwnerResponse_QNAME = new QName("http://sessionBeans/", "getFilesByOwnerResponse");
    private final static QName _RemoveFileResponse_QNAME = new QName("http://sessionBeans/", "removeFileResponse");
    private final static QName _FindRequestByIdResponse_QNAME = new QName("http://sessionBeans/", "findRequestByIdResponse");
    private final static QName _GetFileByUsernameResponse_QNAME = new QName("http://sessionBeans/", "getFileByUsernameResponse");
    private final static QName _GetFilesResponse_QNAME = new QName("http://sessionBeans/", "getFilesResponse");
    private final static QName _RemoveRequestResponse_QNAME = new QName("http://sessionBeans/", "removeRequestResponse");
    private final static QName _GetFiles_QNAME = new QName("http://sessionBeans/", "getFiles");
    private final static QName _GetSahresResponse_QNAME = new QName("http://sessionBeans/", "getSahresResponse");
    private final static QName _RemoveRequest_QNAME = new QName("http://sessionBeans/", "removeRequest");
    private final static QName _UpdateFileResponse_QNAME = new QName("http://sessionBeans/", "updateFileResponse");
    private final static QName _GetFileByIdResponse_QNAME = new QName("http://sessionBeans/", "getFileByIdResponse");
    private final static QName _GetFilesByOwner_QNAME = new QName("http://sessionBeans/", "getFilesByOwner");
    private final static QName _GetRequests_QNAME = new QName("http://sessionBeans/", "getRequests");
    private final static QName _SaveRequest_QNAME = new QName("http://sessionBeans/", "saveRequest");
    private final static QName _AddFileResponse_QNAME = new QName("http://sessionBeans/", "addFileResponse");
    private final static QName _UpdateFile_QNAME = new QName("http://sessionBeans/", "updateFile");
    private final static QName _SaveRequestResponse_QNAME = new QName("http://sessionBeans/", "saveRequestResponse");
    private final static QName _FindByNameResponse_QNAME = new QName("http://sessionBeans/", "findByNameResponse");
    private final static QName _FindByName_QNAME = new QName("http://sessionBeans/", "findByName");
    private final static QName _GetFileByUsername_QNAME = new QName("http://sessionBeans/", "getFileByUsername");
    private final static QName _FindRequestById_QNAME = new QName("http://sessionBeans/", "findRequestById");
    private final static QName _GetRequestsResponse_QNAME = new QName("http://sessionBeans/", "getRequestsResponse");
    private final static QName _GetFileById_QNAME = new QName("http://sessionBeans/", "getFileById");
    private final static QName _DownloadFile_QNAME = new QName("http://sessionBeans/", "downloadFile");
    private final static QName _RemoveFile_QNAME = new QName("http://sessionBeans/", "removeFile");
    private final static QName _AddFile_QNAME = new QName("http://sessionBeans/", "addFile");
    private final static QName _ShareFile_QNAME = new QName("http://sessionBeans/", "shareFile");
    private final static QName _ShareFileResponse_QNAME = new QName("http://sessionBeans/", "shareFileResponse");
    private final static QName _DownloadFileResponse_QNAME = new QName("http://sessionBeans/", "downloadFileResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sessionbeans
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSahres }
     * 
     */
    public GetSahres createGetSahres() {
        return new GetSahres();
    }

    /**
     * Create an instance of {@link GetFileByUsername }
     * 
     */
    public GetFileByUsername createGetFileByUsername() {
        return new GetFileByUsername();
    }

    /**
     * Create an instance of {@link SaveRequest }
     * 
     */
    public SaveRequest createSaveRequest() {
        return new SaveRequest();
    }

    /**
     * Create an instance of {@link RemoveRequest }
     * 
     */
    public RemoveRequest createRemoveRequest() {
        return new RemoveRequest();
    }

    /**
     * Create an instance of {@link SaveRequestResponse }
     * 
     */
    public SaveRequestResponse createSaveRequestResponse() {
        return new SaveRequestResponse();
    }

    /**
     * Create an instance of {@link ShareFile }
     * 
     */
    public ShareFile createShareFile() {
        return new ShareFile();
    }

    /**
     * Create an instance of {@link UpdateFileResponse }
     * 
     */
    public UpdateFileResponse createUpdateFileResponse() {
        return new UpdateFileResponse();
    }

    /**
     * Create an instance of {@link GetFileByUsernameResponse }
     * 
     */
    public GetFileByUsernameResponse createGetFileByUsernameResponse() {
        return new GetFileByUsernameResponse();
    }

    /**
     * Create an instance of {@link DownloadFileResponse }
     * 
     */
    public DownloadFileResponse createDownloadFileResponse() {
        return new DownloadFileResponse();
    }

    /**
     * Create an instance of {@link ShareFileResponse }
     * 
     */
    public ShareFileResponse createShareFileResponse() {
        return new ShareFileResponse();
    }

    /**
     * Create an instance of {@link GetRequests }
     * 
     */
    public GetRequests createGetRequests() {
        return new GetRequests();
    }

    /**
     * Create an instance of {@link GetFilesByOwnerResponse }
     * 
     */
    public GetFilesByOwnerResponse createGetFilesByOwnerResponse() {
        return new GetFilesByOwnerResponse();
    }

    /**
     * Create an instance of {@link FindByName }
     * 
     */
    public FindByName createFindByName() {
        return new FindByName();
    }

    /**
     * Create an instance of {@link RemoveFileResponse }
     * 
     */
    public RemoveFileResponse createRemoveFileResponse() {
        return new RemoveFileResponse();
    }

    /**
     * Create an instance of {@link RemoveFile }
     * 
     */
    public RemoveFile createRemoveFile() {
        return new RemoveFile();
    }

    /**
     * Create an instance of {@link GetRequestsResponse }
     * 
     */
    public GetRequestsResponse createGetRequestsResponse() {
        return new GetRequestsResponse();
    }

    /**
     * Create an instance of {@link GetFilesByOwner }
     * 
     */
    public GetFilesByOwner createGetFilesByOwner() {
        return new GetFilesByOwner();
    }

    /**
     * Create an instance of {@link RemoveRequestResponse }
     * 
     */
    public RemoveRequestResponse createRemoveRequestResponse() {
        return new RemoveRequestResponse();
    }

    /**
     * Create an instance of {@link FileShare }
     * 
     */
    public FileShare createFileShare() {
        return new FileShare();
    }

    /**
     * Create an instance of {@link GetFileById }
     * 
     */
    public GetFileById createGetFileById() {
        return new GetFileById();
    }

    /**
     * Create an instance of {@link GetFiles }
     * 
     */
    public GetFiles createGetFiles() {
        return new GetFiles();
    }

    /**
     * Create an instance of {@link FileRequest }
     * 
     */
    public FileRequest createFileRequest() {
        return new FileRequest();
    }

    /**
     * Create an instance of {@link FileInfo }
     * 
     */
    public FileInfo createFileInfo() {
        return new FileInfo();
    }

    /**
     * Create an instance of {@link AddFileResponse }
     * 
     */
    public AddFileResponse createAddFileResponse() {
        return new AddFileResponse();
    }

    /**
     * Create an instance of {@link AddFile }
     * 
     */
    public AddFile createAddFile() {
        return new AddFile();
    }

    /**
     * Create an instance of {@link UpdateFile }
     * 
     */
    public UpdateFile createUpdateFile() {
        return new UpdateFile();
    }

    /**
     * Create an instance of {@link FindRequestById }
     * 
     */
    public FindRequestById createFindRequestById() {
        return new FindRequestById();
    }

    /**
     * Create an instance of {@link FindRequestByIdResponse }
     * 
     */
    public FindRequestByIdResponse createFindRequestByIdResponse() {
        return new FindRequestByIdResponse();
    }

    /**
     * Create an instance of {@link GetSahresResponse }
     * 
     */
    public GetSahresResponse createGetSahresResponse() {
        return new GetSahresResponse();
    }

    /**
     * Create an instance of {@link DownloadFile }
     * 
     */
    public DownloadFile createDownloadFile() {
        return new DownloadFile();
    }

    /**
     * Create an instance of {@link FindByNameResponse }
     * 
     */
    public FindByNameResponse createFindByNameResponse() {
        return new FindByNameResponse();
    }

    /**
     * Create an instance of {@link GetFileByIdResponse }
     * 
     */
    public GetFileByIdResponse createGetFileByIdResponse() {
        return new GetFileByIdResponse();
    }

    /**
     * Create an instance of {@link GetFilesResponse }
     * 
     */
    public GetFilesResponse createGetFilesResponse() {
        return new GetFilesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSahres }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getSahres")
    public JAXBElement<GetSahres> createGetSahres(GetSahres value) {
        return new JAXBElement<GetSahres>(_GetSahres_QNAME, GetSahres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilesByOwnerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getFilesByOwnerResponse")
    public JAXBElement<GetFilesByOwnerResponse> createGetFilesByOwnerResponse(GetFilesByOwnerResponse value) {
        return new JAXBElement<GetFilesByOwnerResponse>(_GetFilesByOwnerResponse_QNAME, GetFilesByOwnerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "removeFileResponse")
    public JAXBElement<RemoveFileResponse> createRemoveFileResponse(RemoveFileResponse value) {
        return new JAXBElement<RemoveFileResponse>(_RemoveFileResponse_QNAME, RemoveFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRequestByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "findRequestByIdResponse")
    public JAXBElement<FindRequestByIdResponse> createFindRequestByIdResponse(FindRequestByIdResponse value) {
        return new JAXBElement<FindRequestByIdResponse>(_FindRequestByIdResponse_QNAME, FindRequestByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getFileByUsernameResponse")
    public JAXBElement<GetFileByUsernameResponse> createGetFileByUsernameResponse(GetFileByUsernameResponse value) {
        return new JAXBElement<GetFileByUsernameResponse>(_GetFileByUsernameResponse_QNAME, GetFileByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getFilesResponse")
    public JAXBElement<GetFilesResponse> createGetFilesResponse(GetFilesResponse value) {
        return new JAXBElement<GetFilesResponse>(_GetFilesResponse_QNAME, GetFilesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "removeRequestResponse")
    public JAXBElement<RemoveRequestResponse> createRemoveRequestResponse(RemoveRequestResponse value) {
        return new JAXBElement<RemoveRequestResponse>(_RemoveRequestResponse_QNAME, RemoveRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFiles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getFiles")
    public JAXBElement<GetFiles> createGetFiles(GetFiles value) {
        return new JAXBElement<GetFiles>(_GetFiles_QNAME, GetFiles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSahresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getSahresResponse")
    public JAXBElement<GetSahresResponse> createGetSahresResponse(GetSahresResponse value) {
        return new JAXBElement<GetSahresResponse>(_GetSahresResponse_QNAME, GetSahresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "removeRequest")
    public JAXBElement<RemoveRequest> createRemoveRequest(RemoveRequest value) {
        return new JAXBElement<RemoveRequest>(_RemoveRequest_QNAME, RemoveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "updateFileResponse")
    public JAXBElement<UpdateFileResponse> createUpdateFileResponse(UpdateFileResponse value) {
        return new JAXBElement<UpdateFileResponse>(_UpdateFileResponse_QNAME, UpdateFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getFileByIdResponse")
    public JAXBElement<GetFileByIdResponse> createGetFileByIdResponse(GetFileByIdResponse value) {
        return new JAXBElement<GetFileByIdResponse>(_GetFileByIdResponse_QNAME, GetFileByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilesByOwner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getFilesByOwner")
    public JAXBElement<GetFilesByOwner> createGetFilesByOwner(GetFilesByOwner value) {
        return new JAXBElement<GetFilesByOwner>(_GetFilesByOwner_QNAME, GetFilesByOwner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRequests }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getRequests")
    public JAXBElement<GetRequests> createGetRequests(GetRequests value) {
        return new JAXBElement<GetRequests>(_GetRequests_QNAME, GetRequests.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "saveRequest")
    public JAXBElement<SaveRequest> createSaveRequest(SaveRequest value) {
        return new JAXBElement<SaveRequest>(_SaveRequest_QNAME, SaveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "addFileResponse")
    public JAXBElement<AddFileResponse> createAddFileResponse(AddFileResponse value) {
        return new JAXBElement<AddFileResponse>(_AddFileResponse_QNAME, AddFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "updateFile")
    public JAXBElement<UpdateFile> createUpdateFile(UpdateFile value) {
        return new JAXBElement<UpdateFile>(_UpdateFile_QNAME, UpdateFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "saveRequestResponse")
    public JAXBElement<SaveRequestResponse> createSaveRequestResponse(SaveRequestResponse value) {
        return new JAXBElement<SaveRequestResponse>(_SaveRequestResponse_QNAME, SaveRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "findByNameResponse")
    public JAXBElement<FindByNameResponse> createFindByNameResponse(FindByNameResponse value) {
        return new JAXBElement<FindByNameResponse>(_FindByNameResponse_QNAME, FindByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "findByName")
    public JAXBElement<FindByName> createFindByName(FindByName value) {
        return new JAXBElement<FindByName>(_FindByName_QNAME, FindByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getFileByUsername")
    public JAXBElement<GetFileByUsername> createGetFileByUsername(GetFileByUsername value) {
        return new JAXBElement<GetFileByUsername>(_GetFileByUsername_QNAME, GetFileByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRequestById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "findRequestById")
    public JAXBElement<FindRequestById> createFindRequestById(FindRequestById value) {
        return new JAXBElement<FindRequestById>(_FindRequestById_QNAME, FindRequestById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRequestsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getRequestsResponse")
    public JAXBElement<GetRequestsResponse> createGetRequestsResponse(GetRequestsResponse value) {
        return new JAXBElement<GetRequestsResponse>(_GetRequestsResponse_QNAME, GetRequestsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "getFileById")
    public JAXBElement<GetFileById> createGetFileById(GetFileById value) {
        return new JAXBElement<GetFileById>(_GetFileById_QNAME, GetFileById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "downloadFile")
    public JAXBElement<DownloadFile> createDownloadFile(DownloadFile value) {
        return new JAXBElement<DownloadFile>(_DownloadFile_QNAME, DownloadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "removeFile")
    public JAXBElement<RemoveFile> createRemoveFile(RemoveFile value) {
        return new JAXBElement<RemoveFile>(_RemoveFile_QNAME, RemoveFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "addFile")
    public JAXBElement<AddFile> createAddFile(AddFile value) {
        return new JAXBElement<AddFile>(_AddFile_QNAME, AddFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShareFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "shareFile")
    public JAXBElement<ShareFile> createShareFile(ShareFile value) {
        return new JAXBElement<ShareFile>(_ShareFile_QNAME, ShareFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShareFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "shareFileResponse")
    public JAXBElement<ShareFileResponse> createShareFileResponse(ShareFileResponse value) {
        return new JAXBElement<ShareFileResponse>(_ShareFileResponse_QNAME, ShareFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sessionBeans/", name = "downloadFileResponse")
    public JAXBElement<DownloadFileResponse> createDownloadFileResponse(DownloadFileResponse value) {
        return new JAXBElement<DownloadFileResponse>(_DownloadFileResponse_QNAME, DownloadFileResponse.class, null, value);
    }

}
