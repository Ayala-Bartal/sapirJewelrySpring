package spring.repository.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spring.entities.UserDbE;
import spring.repository.interfaces.UserRepositoryI;

public class UsersRepositoryInMemory implements UserRepositoryI {
	
	/*ArrayList <String> m_lstUsers = new ArrayList <String>();*/
	Map <String, UserDbE> m_map = new HashMap <String, UserDbE>();

	public UserDbE save(UserDbE user) {
		m_map.put(user.getFirstName(), user);
		return user;
		
	}

	public Collection <UserDbE> getAll() {
		return this.m_map.values();
	}

	public UserDbE get(String name) {
		return m_map.get(name);
	}

}
