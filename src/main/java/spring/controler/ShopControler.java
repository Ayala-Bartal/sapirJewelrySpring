package spring.controler;

import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.entities.ShopDbE;
import spring.entities.UserDbE;
import spring.services.classes.ShopServiceImpl;
import spring.services.classes.UserServiceImpl;
import spring.services.interfaces.ShopServiseI;
import spring.services.interfaces.UserServiseI;

@Controller
@RequestMapping("/shop")
public class ShopControler {
	
	ShopServiseI m_shopServise;
	
	public ShopControler (){
		m_shopServise = new ShopServiceImpl ();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    Collection <ShopDbE> allusers() throws Exception {
        return m_shopServise.getAll();
    }
    
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    @ResponseBody
    ShopDbE ayala(@PathVariable String name) throws Exception {
        return m_shopServise.get(name);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    ShopDbE addUserName(@RequestBody ShopDbE user) throws Exception {
        return m_shopServise.add(user);
    }
}