package birthtech.service.tests;

import infosource.health.ematclinic.interfaces.IChildService;
import infosource.health.ematclinic.ioc.IOContiner;
import infosource.health.ematclinic.services.CheckupService;
import infosource.health.ematclinic.services.IClinicService;
import infosource.health.ematclinic.services.gggg;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class sometest {
	private IChildService c;
	
// @Test
	public void some() {
	 Injector injector = Guice.createInjector(new  IOContiner());
	 IClinicService service= injector.getInstance(IClinicService.class);
	
	System.out.println("The size is: "+service.getCheckups().size());
	}
 
}
