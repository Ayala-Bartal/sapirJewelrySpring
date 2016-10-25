package spring.services.interfaces;

import java.io.File;
import java.util.Collection;

import spring.entities.ShopDbE;
import spring.entities.UserDbE;

public interface ShopServiseI {
	
	public ShopDbE add (ShopDbE user) throws Exception;
	
	public Collection<ShopDbE> getAll () throws Exception;

	public ShopDbE get(String name) throws Exception;

	public File getImage(String string)  throws Exception;
}
