package spring.services.interfaces;

import java.util.Collection;

import spring.entities.ShopDbE;
import spring.entities.UserDbE;

public interface ShopServiseI {
	
	public ShopDbE add (ShopDbE user) throws Exception;
	
	public Collection<ShopDbE> getAll () throws Exception;

	public ShopDbE get(String name) throws Exception;
}
