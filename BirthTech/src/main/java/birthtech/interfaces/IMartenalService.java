package birthtech.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import birthtech.entities.Martenal;
@Service
public interface IMartenalService {
	public boolean addMartenal(String fullname, Date date,String nurse);
	public List<Martenal> getMartenal();
}
