
package webframeapp.servicelgoic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "NewsFeedService", targetNamespace = "http://serviceLgoic.webFrameApp/", wsdlLocation = "http://localhost:8080/RDwebFrameApp/NewsFeedService?wsdl")
public class NewsFeedService
    extends Service
{

    private final static URL NEWSFEEDSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(webframeapp.servicelgoic.NewsFeedService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = webframeapp.servicelgoic.NewsFeedService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/RDwebFrameApp/NewsFeedService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/RDwebFrameApp/NewsFeedService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        NEWSFEEDSERVICE_WSDL_LOCATION = url;
    }

    public NewsFeedService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NewsFeedService() {
        super(NEWSFEEDSERVICE_WSDL_LOCATION, new QName("http://serviceLgoic.webFrameApp/", "NewsFeedService"));
    }

    /**
     * 
     * @return
     *     returns FeedPostDAO
     */
    @WebEndpoint(name = "NewsFeedServicePort")
    public FeedPostDAO getNewsFeedServicePort() {
        return super.getPort(new QName("http://serviceLgoic.webFrameApp/", "NewsFeedServicePort"), FeedPostDAO.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FeedPostDAO
     */
    @WebEndpoint(name = "NewsFeedServicePort")
    public FeedPostDAO getNewsFeedServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://serviceLgoic.webFrameApp/", "NewsFeedServicePort"), FeedPostDAO.class, features);
    }

}
