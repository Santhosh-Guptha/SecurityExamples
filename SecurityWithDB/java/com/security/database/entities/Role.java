package com.security.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Role {
	@Id
	@GeneratedValue
	private int role_id;
	private String role;
}
