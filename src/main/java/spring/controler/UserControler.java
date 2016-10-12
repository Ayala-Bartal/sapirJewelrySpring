package spring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class UserControler {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String orbartal() {
        return "Hello from no name";
    }
    
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    String ayala(@PathVariable String name) {
        return "Hello from "+name;
    }


}
