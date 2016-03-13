package wsApp;

import javax.jws.WebService;


@WebService
public class CustomerEndpoint implements CustomerService
{
 

	@Override
	public Customer getCustomerById(String customerId)
	{
		Customer customer= new Customer();
		 customer.setId(customerId);
		 customer.setName("Lizo");
		 customer.setSurname("Masikisiki");
		return customer;
	}

	
}