package com.example.spring.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.example.spring.entity.Employee;

@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	IEmployeeRepository empRepository;

	@Test
	void testGetEmployeeByName() {
		List<Employee> employees = empRepository.findByEmpName("Kavitha");
		assertEquals(1, employees.size());
	}

	@Test
	void testGetEmployeeBySalary() {
		List<Employee> employees = empRepository.findBySalary(10000);
		assertEquals(1, employees.size());
	}

}
