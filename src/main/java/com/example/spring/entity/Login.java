package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Data
public class Login {

	@Id
	@Email(message="Enter valid email address")
	private String email;
	private String password;
}
