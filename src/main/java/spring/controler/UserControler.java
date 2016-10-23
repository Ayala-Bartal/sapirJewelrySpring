package spring.controler;

import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.entities.UserDbE;
import spring.services.classes.UserServiceImpl;
import spring.services.interfaces.UserServiseI;

@Controller
@RequestMapping("/users")
public class UserControler {
	
	UserServiseI m_userServise;
	
	public UserControler (){
		m_userServise = new UserServiceImpl ();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    Collection <UserDbE> allusers() throws Exception {
        return m_userServise.getAll();
    }
    
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    @ResponseBody
    UserDbE ayala(@PathVariable String name) throws Exception {
        return m_userServise.get(name);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    UserDbE addUserName(@RequestBody UserDbE user) throws Exception {
        return m_userServise.add(user);
    }
}