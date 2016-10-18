package spring.services.interfaces;

import java.util.Collection;
import java.util.List;

import spring.entities.UserDbE;

public interface UserServiseI {
	
	public UserDbE add (UserDbE user);
	
	public Collection<UserDbE> getAll ();

	public UserDbE get(String name);

}
