package birthtech.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
 



import birthtech.entities.Child;
import birthtech.entities.Labour;
import birthtech.entities.Maternity;
import birthtech.enums.LabourStatusEnum;
import birthtech.interfaces.ILabourService;
import birthtech.messaging.MessageSender;
import birthtech.repositories.LabourRepository;

@Service
public class LabourService implements ILabourService {
	@Autowired
	private LabourRepository labourRepo;

	@Override
	public boolean addLabour(Date date, String place, int status,
			Maternity parent, String nurse, int birthnumber) {
		Labour labour = new Labour();
		labour.setBirthNo(birthnumber);
		labour.setLabourDate(date);
		labour.setMartenal(parent);
		labour.setStatus(status);
		Labour lab = labourRepo.save(labour);
		if (lab != null) {
			MessageSender sender = new MessageSender();
			Gson jsonMapper= new Gson();
			sender.sendMessage(jsonMapper.toJson(lab));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Labour getLabour(int lid) {
		List<Labour> listLabour = new ArrayList<Labour>();
		for (Labour labour : labourRepo.findAll()) {
			if (labour.getLabourId() == lid) {
				listLabour.add(labour);
			}
		}
		return listLabour.get(0);
	}

	@Override
	public List<Labour> getLabour() {
		System.out.println("Labour service method- list invoked...");
		return labourRepo.findAll();
	}

	@Override
	public List<Labour> getLabour(Maternity martenal) {
		List<Labour> listLabour = new ArrayList<Labour>();
		for (Labour labour : labourRepo.findAll()) {
			if (labour.getMartenal() == martenal) {
				listLabour.add(labour);
			}
		}
		return listLabour;
	}

	@Override
	public List<Labour> getLabour(Date date) {
		List<Labour> listLabour = new ArrayList<Labour>();
		for (Labour labour : labourRepo.findAll()) {
			if (labour.getLabourDate() == date) {
				listLabour.add(labour);
			}
		}
		return listLabour;
	}

}
