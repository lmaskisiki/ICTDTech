package infosource.soap.client.customapp;

import java.util.List;

import org.springframework.stereotype.Component;

import webframeapp.interfaces.CreateDomain;
import webframeapp.interfaces.CreateDomainResponse;
import webframeapp.interfaces.Domain;
import webframeapp.interfaces.FindByCreator;
import webframeapp.interfaces.GetAllDomains;
import webframeapp.interfaces.GetAllDomainsResponse;
 public class DomainService {

	public GetAllDomains getDomains() {
		GetAllDomains damainRequest = new GetAllDomains();
		return damainRequest;
	}

	public GetAllDomainsResponse getDomainsResponse(GetAllDomainsResponse domains) {
		GetAllDomainsResponse res = new GetAllDomainsResponse();
		List<Domain> domainList = domains.getReturn();
		return domains;
	}

	public String findByCreator(String str) {

		FindByCreator req = new FindByCreator();
		req.setArg0(str);
		return str;
	}

	public CreateDomain createDomain(String creator, String dominName,
			String category, String domainOrg, String contact,
			String description) {
		CreateDomain create = new CreateDomain();
		create.setArg0(creator);
		create.setArg0(dominName);
		create.setArg0(category);
		create.setArg0(domainOrg);
		create.setArg0(contact);
		create.setArg0(description);

		return create;

	}
	public  CreateDomainResponse createDomainResponse(){
		 CreateDomainResponse res=new  CreateDomainResponse();
		 
		 return res;
		 
	 }
	
}
