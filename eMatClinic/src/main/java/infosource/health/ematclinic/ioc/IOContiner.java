package infosource.health.ematclinic.ioc;
 
 
import infosource.health.ematclinic.interfaces.ICheckupService;
import infosource.health.ematclinic.interfaces.IChildService;
import infosource.health.ematclinic.interfaces.ILabourService;
import infosource.health.ematclinic.interfaces.IMartenalService;
import infosource.health.ematclinic.services.CheckupService;
import infosource.health.ematclinic.services.ChildService;
import infosource.health.ematclinic.services.ClinicService;
import infosource.health.ematclinic.services.IClinicService;
import infosource.health.ematclinic.services.LabourService;
import infosource.health.ematclinic.services.MaternityService;

import com.google.inject.AbstractModule;

public class IOContiner extends AbstractModule {
 
	@Override
	protected void configure() {
	
		bind(ICheckupService.class).to(CheckupService.class);
		bind(IChildService.class).to(ChildService.class);
		bind(ILabourService.class).to(LabourService.class);
		bind(IMartenalService.class).to(MaternityService.class);
		bind(IClinicService.class).to(ClinicService.class);
	}

}
