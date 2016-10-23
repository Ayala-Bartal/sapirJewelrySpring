package spring.services.classes;

import java.util.Collection;
import spring.entities.UserDbE;
import spring.repository.classes.UserRepositoryInExcel;
import spring.repository.interfaces.UserRepositoryI;
import spring.services.interfaces.UserServiseI;

public class UserServiceImpl implements UserServiseI {
	
	UserRepositoryI m_usersRepository;
	
	public UserServiceImpl (){
		m_usersRepository = new UserRepositoryInExcel();
	}
	

	public UserDbE add(UserDbE user) throws Exception {
		return m_usersRepository.save(user);
	}

	public Collection <UserDbE> getAll() throws Exception {
		Collection<UserDbE> lstUsers = m_usersRepository.getAll();
		return lstUsers;
	}


	public UserDbE get(String name) throws Exception {
		return m_usersRepository.get(name);
	}

}
