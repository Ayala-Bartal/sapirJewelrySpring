package spring.repository.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import spring.entities.UserDbE;

public interface UserRepositoryI {
	
	public UserDbE save (UserDbE user) throws Exception;
	
	public Collection <UserDbE> getAll() throws Exception; 

	public UserDbE get(String name) throws Exception;

}
