package com.security.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.entities.User;
import com.security.demo.services.UserServices;

@RestController
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequestMapping("/user")
public class MyController {
	@Autowired
	private UserServices services;
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/")
	public List<User> getAll(){
		return services.getAllUsers();
	}
//	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/{username}")
	public User getUserById(@PathVariable String username) {
		return services.getUser(username);
	}
//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return services.addUser(user);
	}
}
