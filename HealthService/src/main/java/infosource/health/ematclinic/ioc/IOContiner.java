package infosource.health.ematclinic.ioc;
 
 
import infosource.health.ematclinic.interfaces.ICheckupService;
import infosource.health.ematclinic.interfaces.IChildService;
import infosource.health.ematclinic.interfaces.ILabourService;
import infosource.health.ematclinic.interfaces.IMartenalService;
import infosource.health.ematclinic.service.CheckupService;
import infosource.health.ematclinic.service.ChildService;
import infosource.health.ematclinic.service.ClinicService;
import infosource.health.ematclinic.service.IClinicService;
import infosource.health.ematclinic.service.LabourService;
import infosource.health.ematclinic.service.MaternityService;

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
