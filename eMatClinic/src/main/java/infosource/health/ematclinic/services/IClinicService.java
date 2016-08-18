package infosource.health.ematclinic.services;

import infosource.health.ematclinic.models.Checkup;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IClinicService {

	/* CHECKUP OPERTION */
	public abstract List<Checkup> getCheckups();

	public abstract Checkup findById(String id);

	public abstract void saveAsJson(Checkup checkup);

	public abstract Checkup saveAsObject(String jsonString);

}