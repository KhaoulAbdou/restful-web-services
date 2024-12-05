package com.in28minutes.rest.webservices.restful_web_services.User;

import java.awt.desktop.UserSessionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	public static int idCount = 0;
	
	static {
		
		users.add(new User(++idCount,"Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++idCount,"Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++idCount,"Jim", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
		
	}
	
	/*
	 * public List<User> findUser(Integer id){ List<User> result = new
	 * ArrayList<>(); for (User user : users) { if (user.getId()==id)
	 * result.add(user); } return result; }
	 */	
	
	  public User findOne(int id) { 
		 
		  Predicate<? super User> predicate = user -> user.getId().equals(id);
		  return users.stream().filter(predicate).findFirst().orElse(null);
		  }
	  
	  public User  save(User user) {
		  user.setId(++idCount);
		  users.add(user);
		  return user;
	  }

}
