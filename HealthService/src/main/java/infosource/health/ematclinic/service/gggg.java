package infosource.health.ematclinic.service;

import com.google.inject.Inject;

public class gggg {
	@Inject
	public gggg(IClinicService service) {
		 System.out.println("The coments for:: "+service.getCheckups().get(0).getComments());

	}
	public static void main(String[] args) {
		
		 

	}

}
