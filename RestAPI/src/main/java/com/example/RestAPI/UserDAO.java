package com.example.RestAPI;

import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

//because I want userDAO tp be managed by spring.
//I put @Component means userDAO is a bean now that will be managed by spring
@Component
public class UserDAO {
	private static List<UserAccount> users  = new ArrayList<>();
	private static Integer usersCount = 3;
	static {
		users.add(new UserAccount(1, "Purvee", new Date()));
		users.add(new UserAccount(2, "Garima", new Date()));
		users.add(new UserAccount(3, "Ishani", new Date()));

	}
	
	public List<UserAccount> findAll(){
		return users;
		
	}
	
	public UserAccount save(UserAccount user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public UserAccount findOne(Integer id) {
		for(UserAccount user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	
	public UserAccount deleteById(Integer id) {
		//Because we can't remove from middle of a request, so we have to 
		// create a new List, store the new list(after removal) there, and
		// return a new user.
		Iterator<UserAccount> iterator = users.iterator();
		while(iterator.hasNext()) {
			UserAccount user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
		
	}

}
