package spring.repository;

import java.util.List;

public interface UserRepositoryI {
	
	public String save (String userName);
	
	public List <String> getAll();

}
