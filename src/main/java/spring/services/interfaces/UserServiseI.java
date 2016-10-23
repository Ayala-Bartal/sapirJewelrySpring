package spring.services.interfaces;

import java.util.Collection;
import java.util.List;

import spring.entities.UserDbE;

public interface UserServiseI {
	
	public UserDbE add (UserDbE user) throws Exception;
	
	public Collection<UserDbE> getAll () throws Exception;

	public UserDbE get(String name) throws Exception;

}
