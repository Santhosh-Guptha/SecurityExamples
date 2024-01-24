package com.security.database.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.database.entities.User;
import com.security.database.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		CustomUserDetails userDeatls = null;
		if(user!=null) {
			userDeatls = new CustomUserDetails();
			userDeatls.setUser(user);
		}
		else {
			throw new UsernameNotFoundException("User not exist with name"+username);
		}
		return null;
	}

}
