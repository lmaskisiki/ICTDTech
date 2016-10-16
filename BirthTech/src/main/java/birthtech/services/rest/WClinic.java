package birthtech.services.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.language.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import birthtech.entities.Checkup;
import birthtech.entities.Child;
import birthtech.entities.Labour;
import birthtech.entities.Patient;
import birthtech.interfaces.ICheckupService;
import birthtech.interfaces.IChildService;
import birthtech.interfaces.IMartenalService;
import birthtech.services.LabourService;

@Component
public class WClinic implements IWclinic {
	@Autowired
	private ICheckupService checkupService;
	@Autowired
	private IMartenalService matService;
	@Autowired
	private IChildService childService;
	@Autowired
	private LabourService labService;

	@Override
	public List<Checkup> checkuplist(String patientId) {
		List<Checkup> rs=  checkupService.getCheckups(Integer.parseInt(patientId));
		//Gson g = new Gson();
		//String ar=g.toJson(rs);
		//System.out.print("\n \n "+ar);
		 return rs;
	}

	@Override
	public List<Child> children(String patientId) {
		return childService.getChildren(matService.getMaternityById(Integer
				.parseInt(patientId)));
	}

	@Override
	public List<Patient> patients() {
		return matService.getMartenal();
	}

	@Override
	public List<Labour> labourevent() {
		return labService.getLabour();
	}

	public boolean isValid(Labour lab) {
		if (lab.getChild() != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Labour> labourevent(String day) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Labour> list = new ArrayList<Labour>();
		List<Labour> all = labService.getLabour();
		int countValid = 0;
		try {
			for (Labour lab : all) {
				if (isValid(lab)) {
				
					if ((fmt.format(lab.getLabourDate())).contains(day)) {
						Date fmtDate = fmt2.parse(fmt2.format(lab.getLabourDate()));
						countValid++;
						lab.setLabourDate(fmtDate);
						list.add(lab);
					}
				}
			}
			if (countValid == 0) {
				System.out.println("No valid entities found for this date");
			} else {
				System.out.println(countValid + " entities were found!");
			}
		} catch (Exception ex) {
			System.out.println("Something is not right");
		}
		return list;
	}

}
