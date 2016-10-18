package spring.repository.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import spring.entities.UserDbE;

public interface UserRepositoryI {
	
	public UserDbE save (UserDbE user);
	
	public Collection <UserDbE> getAll();

	public UserDbE get(String name);

}
