package spring.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
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
    
    @RequestMapping(value = "image", method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fullPath = "C:\\1\\sapirPphoto\\446707.jpg";   
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
    	setMimeType(request, response, fullPath);
        response.setContentLength((int) downloadFile.length());
        OutputStream outStream = response.getOutputStream();
        IOUtils.copy(inputStream, outStream);
    }

	private void setMimeType(HttpServletRequest request, HttpServletResponse response, String fullPath) {
        ServletContext context = request.getServletContext();
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
	}
}