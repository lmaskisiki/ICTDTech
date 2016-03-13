package wsApp;

import javax.jws.WebService;

@WebService(serviceName="customerService")
public interface CustomerService 
{
	public Customer getCustomerById(String customerId);

}