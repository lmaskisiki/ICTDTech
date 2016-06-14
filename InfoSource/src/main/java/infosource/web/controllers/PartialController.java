package infosource.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PartialController {

	
	@RequestMapping(value="partial/userprofile", method=RequestMethod.GET)
	public String partial_userprofile(){
				return "userprofile";
	}
	@RequestMapping(value="partial/newsfeeds", method=RequestMethod.GET)
	public String partial_newsfeeds(){
				return "newsfeeds";
	}
}
