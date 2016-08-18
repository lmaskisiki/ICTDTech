package infosource.health.ematclinic.service;

import org.apache.camel.converter.IOConverter;
import org.springframework.stereotype.Service;

import sun.print.resources.serviceui;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import infosource.health.ematclinic.interfaces.ICheckupService;
import infosource.health.ematclinic.ioc.IOContiner;

@Service
public class InjectorTest {
  
	 public void doSomething(){
		System.out.println("Lizo Masikisiki passionate programmer");
		Injector in= Guice.createInjector(new IOContiner());
		ICheckupService service= in.getInstance(ICheckupService.class);
		System.out.println(service.getClass()+"\n" );
		
		
		
	}
}
