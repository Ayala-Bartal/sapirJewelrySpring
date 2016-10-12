package spring.services.classes;

import java.util.ArrayList;
import java.util.List;

import spring.repository.UserRepositoryI;
import spring.repository.classes.UsersRepositoryInMemory;
import spring.services.interfaces.UserServiseI;

public class UserService implements UserServiseI {
	
	UserRepositoryI m_usersRepository;
	
	public UserService (){
		m_usersRepository = new UsersRepositoryInMemory();
	}
	

	public String add(String strUserName) {
		return m_usersRepository.save(strUserName);
	}

	public String getAll() {
		List<String> lstUsers = m_usersRepository.getAll();
		String strUsers = "";
		for (String s: lstUsers){
			strUsers += s + ", ";
		}
		return strUsers;
	}

}
