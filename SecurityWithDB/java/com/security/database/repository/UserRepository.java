package com.security.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.database.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
