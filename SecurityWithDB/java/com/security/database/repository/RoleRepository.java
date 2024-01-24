package com.security.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.database.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
