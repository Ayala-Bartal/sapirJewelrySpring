package spring.repository.interfaces;

import java.util.Collection;

import spring.entities.ShopDbE;
import spring.entities.UserDbE;

public interface ShopRepositoryI {
	
	public ShopDbE save (ShopDbE user) throws Exception;
	
	public Collection <ShopDbE> getAll() throws Exception; 

	public ShopDbE get(String name) throws Exception;

}
