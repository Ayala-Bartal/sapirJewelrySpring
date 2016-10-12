package spring.repository.classes;

import java.util.ArrayList;
import java.util.List;

import spring.repository.UserRepositoryI;

public class UsersRepositoryInMemory implements UserRepositoryI {
	
	ArrayList <String> m_lstUsers = new ArrayList <String>();

	public String save(String userName) {
		m_lstUsers.add(userName);
		return userName;
		
	}

	public List<String> getAll() {
		// TODO Auto-generated method stub
		return this.m_lstUsers;
	}

}
