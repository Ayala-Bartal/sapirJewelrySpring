/*
package spring.repository.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import spring.repository.interfaces.UserRepositoryI;

public class UserRepositoryTxtFile implements UserRepositoryI {
	
	String m_filePath = "C:\\1\\SapirUsers.txt";
	
	public String save(String userName) {
		try {
			String userName2 = userName +"\n";
		    Files.write(Paths.get(m_filePath), userName2.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
			e.toString();
		}
		return userName;
	}

	public List<String> getAll() {
		try {
			List<String> result = Files.readAllLines(Paths.get(m_filePath));
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<String>();
		}
		
	}

}
*/