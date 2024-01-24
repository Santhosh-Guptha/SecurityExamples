package com.security.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.demo.entities.User;

@Service
public class UserServices {

	
	List<User> list = new ArrayList<>();
	
	public UserServices() {
		list.add(new User("santhosh","santhosh@18","santhoshbukka5@gmail.com"));
		list.add(new User("rajaram","rajaram@18","rajaram@gmail.com"));
		list.add(new User("akil","akil@18","akil@gmail.com"));
		list.add(new User("sai","sai@18","sai@gmail.com"));
		list.add(new User("kalyan","kalyan@18","kalyan@gmail.com"));
	}
	
	
	//get all users
	public List<User> getAllUsers(){
		return this.list;
	}
	
	
	//get by username
	public User getUser(String username) {
		return list.stream().filter((user)->user.getUsername().equals(username)).findAny().get();
	}
	
	
	//add user
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
