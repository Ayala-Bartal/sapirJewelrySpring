package spring.services.classes;

import java.util.ArrayList;

import spring.services.interfaces.UserServiseI;

public class UserService implements UserServiseI {
	
	ArrayList <String> users = new ArrayList <String>();

	public String add(String strUserName) {
		users.add(strUserName);
		return strUserName;
	}

	public String getAll() {
		String userList = "";
		for (String s: users){
			userList += s + ", ";
		}
		return userList;
	}

}
