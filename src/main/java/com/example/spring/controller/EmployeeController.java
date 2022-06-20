package com.example.spring.controller;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Address;
import com.example.spring.entity.Employee;
import com.example.spring.entity.Skill;
import com.example.spring.exception.EmployeeNotFoundException;
import com.example.spring.service.IEmployeeService;

@RestController
public class EmployeeController {

	// constructor injection/setter injection/field injection
	@Autowired
	IEmployeeService empServ;

	// get all employees
	@GetMapping("/employees")
	ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = empServ.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// get employee based on emp id
	// localhost:8080/employees/id
	// localhost:8080/employees/234
	@GetMapping("/employee/{id}")
	ResponseEntity<Employee> getEmpById(@PathVariable("id") int empId) throws EmployeeNotFoundException {
		Employee emp = empServ.getEmpById(empId);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	// add employee
	@PostMapping("/employee")
	ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp) {
		Employee newEmp = empServ.addEmployee(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
	}

	// Update Employee
	@PutMapping("/employee/{id}")
	ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee emp, @PathVariable("id") int empId)
			throws EmployeeNotFoundException {
		Employee updatedEmp = empServ.updateEmployeeById(empId, emp);
		return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
	}

	// delete employee
	@DeleteMapping("/employee/{id}")
	ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int empId) {
		Employee emp = empServ.deleteEmployee(empId);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	// patch
	@PatchMapping("/employee/{id}")
	ResponseEntity<Employee> updateEmployeeName(@PathVariable("id") int empId, @RequestBody String newName) {
		Employee updatedEmployee = empServ.updateEmployeeName(empId, newName);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	// update employee address details
	@PatchMapping("/employee/addr/{id}")
	ResponseEntity<Employee> updateEmpAddr(@PathVariable("id") int empId, @RequestBody Address newAddr) {
		Employee emp = empServ.updateEmpAddr(empId, newAddr);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	// Update Employee skills
	@PatchMapping("/employee/skill/{id}")
	ResponseEntity<Employee> updateEmpSkills(@PathVariable("id") int empId, @RequestBody Skill skill) {
		Employee emp = empServ.updateEmpSkill(empId, skill);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping("/employee/name/{empName}")
	ResponseEntity<List<Employee>> getEmployeeByName(String empName) {
		List<Employee> emp = empServ.getEmpByName(empName);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	// get all employees based on salary
	@GetMapping("/employee/salary/{salary}")
	ResponseEntity<List<Employee>> getEmpBySalary(double salary) {
		List<Employee> employees = empServ.getEmpBySalary(salary);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	
	// get all employees whose salary greater than given value
	@GetMapping("/employee/salary/greaterThan/{salary}")
	ResponseEntity<List<Employee>> getEmpBySalaryGreaterThan(double salary) {
		List<Employee> employees = empServ.getEmpBySalaryGreaterThan(salary);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	// get employee based on date of birth
	@GetMapping("/employee/dob/{dob}")
	ResponseEntity<List<Employee>> getEmpByDob(@PathVariable("dob") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate dob) {
		List<Employee> employees = empServ.getEmpByDob(dob);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	

}
