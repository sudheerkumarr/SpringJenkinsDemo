package com.example.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.entity.Employee;
import com.example.spring.entity.Login;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;

@SpringBootTest
public class EmployeeServiceTest {
	
	@Autowired
	IEmployeeService empServ;
	
	//TDD- Test Driven Development 
	// add emp
	@Test
	@Disabled
	@Tag("skip")
	void testAddEmp() {
		Employee emp = new Employee();
		emp.setEmpId(0);
		emp.setEmpName("Atul");
		
		Login login = new Login();
		login.setEmail("atul_2@gmail.com");
		login.setPassword("abc@1234");
		emp.setLogin(login);
		
		Employee newEmp= empServ.addEmployee(emp);
		assertEquals("Atul", newEmp.getEmpName());
		assertEquals("atul_1@gmail.com", newEmp.getLogin().getEmail());
		
	}
	
	// update emp name
	@Test
	void testUpdateEmp() {
		 Employee emp =empServ.updateEmployeeName(53, "Kavitha");
		 assertEquals("Kavitha", emp.getEmpName());
	}
	// delete emp
	@Test
	@Disabled
	@Tag("skip")
	void testDeleteEmp() {
		Employee emp = empServ.deleteEmployee(60);
		assertEquals(60, emp.getEmpId());
	}

	// update emp contact number
	// update emp addr
	// get emp addr
	// get all employees
	@Test
	
	void testGetAllEmployees() {
		List<Employee> employees = empServ.getAllEmployees();
		assertEquals(3, employees.size());
		Employee emp = employees.get(0);
		assertEquals("Geetha", emp.getEmpName());
	}
	// get emp by id
	// 

}
