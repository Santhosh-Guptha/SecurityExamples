package com.security.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.database.entities.User;
import com.security.database.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
//	@Autowired
//	private UserService service;
	@Autowired
	private UserRepository repository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		String pwd = user.getPassword();
		String saved = bCryptPasswordEncoder.encode(pwd);
		user.setPassword(saved);
		return new ResponseEntity<User>(repository.save(user), HttpStatus.CREATED);
	}
}
