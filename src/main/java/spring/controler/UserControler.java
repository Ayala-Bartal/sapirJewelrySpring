package spring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.services.classes.UserService;
import spring.services.interfaces.UserServiseI;

@Controller

public class UserControler {
	
	UserServiseI m_userServise;
	
	public UserControler (){
		m_userServise = new UserService ();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String orbartal() {
        return "Hello from no name";
    }
    
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    String ayala(@PathVariable String name) {
        return "Hello to "+ name;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    String addUserName(@RequestParam("userName") String userName) {
        return m_userServise.add(userName);

    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    String allusers() {
        return m_userServise.getAll();
    }
    
    


}
