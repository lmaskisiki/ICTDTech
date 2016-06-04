
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

    private final static QName _CreatePost_QNAME = new QName("http://interfaces.webFrameApp/", "createPost");
    private final static QName _SayHi_QNAME = new QName("http://interfaces.webFrameApp/", "sayHi");
    private final static QName _CreatePostResponse_QNAME = new QName("http://interfaces.webFrameApp/", "createPostResponse");
    private final static QName _ListPosts_QNAME = new QName("http://interfaces.webFrameApp/", "listPosts");
    private final static QName _SayHiResponse_QNAME = new QName("http://interfaces.webFrameApp/", "sayHiResponse");
    private final static QName _FindById_QNAME = new QName("http://interfaces.webFrameApp/", "findById");
    private final static QName _ListPostsResponse_QNAME = new QName("http://interfaces.webFrameApp/", "listPostsResponse");
    private final static QName _FindByIdResponse_QNAME = new QName("http://interfaces.webFrameApp/", "findByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webframeapp.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListPostsResponse }
     * 
     */
    public ListPostsResponse createListPostsResponse() {
        return new ListPostsResponse();
    }

    /**
     * Create an instance of {@link SayHiResponse }
     * 
     */
    public SayHiResponse createSayHiResponse() {
        return new SayHiResponse();
    }

    /**
     * Create an instance of {@link FeedPost }
     * 
     */
    public FeedPost createFeedPost() {
        return new FeedPost();
    }

    /**
     * Create an instance of {@link CreatePost }
     * 
     */
    public CreatePost createCreatePost() {
        return new CreatePost();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link CreatePostResponse }
     * 
     */
    public CreatePostResponse createCreatePostResponse() {
        return new CreatePostResponse();
    }

    /**
     * Create an instance of {@link SayHi }
     * 
     */
    public SayHi createSayHi() {
        return new SayHi();
    }

    /**
     * Create an instance of {@link ListPosts }
     * 
     */
    public ListPosts createListPosts() {
        return new ListPosts();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "createPost")
    public JAXBElement<CreatePost> createCreatePost(CreatePost value) {
        return new JAXBElement<CreatePost>(_CreatePost_QNAME, CreatePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "sayHi")
    public JAXBElement<SayHi> createSayHi(SayHi value) {
        return new JAXBElement<SayHi>(_SayHi_QNAME, SayHi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "createPostResponse")
    public JAXBElement<CreatePostResponse> createCreatePostResponse(CreatePostResponse value) {
        return new JAXBElement<CreatePostResponse>(_CreatePostResponse_QNAME, CreatePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPosts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "listPosts")
    public JAXBElement<ListPosts> createListPosts(ListPosts value) {
        return new JAXBElement<ListPosts>(_ListPosts_QNAME, ListPosts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "sayHiResponse")
    public JAXBElement<SayHiResponse> createSayHiResponse(SayHiResponse value) {
        return new JAXBElement<SayHiResponse>(_SayHiResponse_QNAME, SayHiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPostsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "listPostsResponse")
    public JAXBElement<ListPostsResponse> createListPostsResponse(ListPostsResponse value) {
        return new JAXBElement<ListPostsResponse>(_ListPostsResponse_QNAME, ListPostsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.webFrameApp/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

}
