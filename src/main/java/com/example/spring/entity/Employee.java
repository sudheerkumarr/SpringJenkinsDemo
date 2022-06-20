package com.example.spring.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue
	private int empId;
	
	@NotNull(message="Name shouldn't be empty")
	@Size(min=3, max=10, message="Min 3 and max 10 charecters are allowed")
	private String empName;
	
	//@Past
	//@FutureOrPresent
	//@Future
	private LocalDate dob;
	
	@URL(message="Enter valid url")
	//"url": "https://www.google.com"
	private String url;
	
	@DecimalMax(value="100000", message="Salary shouldn't be greater than 100000")
	private double salary;

	// OneToOne unidirectional relationship 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email")
	private Login login;

	// OneToOne unidirectional relationship
	// @JsonIgnore
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_addr_fk", referencedColumnName = "empId")
	private List<Address> address;

	@JsonIgnore
	// ManyToMany unidirectional relationship
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "employees_skills", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private Set<Skill> skills;
}
