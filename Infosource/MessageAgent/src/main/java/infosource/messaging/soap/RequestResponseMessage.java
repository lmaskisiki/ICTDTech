package infosource.messaging.soap;

import birthcertificate.ews.soap.Applications;
import birthcertificate.ews.soap.ApplicationsResponse;
import birthcertificate.ews.soap.Approved;
import birthcertificate.ews.soap.ApprovedResponse;

public class RequestResponseMessage {

	public Applications RequestApplication() {
		Applications applications = new Applications();
		return applications;
	}

	public ApplicationsResponse Applications(ApplicationsResponse response) {
		return response;
	}

	public Approved RequestApproved() {
		Approved apr = new Approved();
		return apr;
	}

	public ApprovedResponse ApprovedApplications(ApprovedResponse response) {
		return response;
	}

}
