package com.example.spring.service;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring.entity.Employee;
import com.example.spring.exception.EmployeeNotFoundException;
import com.example.spring.repository.IEmployeeRepository;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceMockitoTest {
	
		// @InjectMock - Creates instance of a class and injects mocks that are created
		// with @Mock

		@InjectMocks
		EmployeeServiceImpl empServ;
		
		
		// @MockBean - Creates Mock of a class or interface
		@MockBean
		IEmployeeRepository empRepo;
		
		// Initialization of mock objects
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}
		
		@Test
		void testGetEmployeeById() throws EmployeeNotFoundException {
			
			Employee emp = new Employee();
			emp.setEmpId(10);
			emp.setEmpName("Ravi");
			
			Mockito.when(empRepo.findById(10)).thenReturn(Optional.of(emp));
			
			Employee emp1 = empServ.getEmpById(10);
			assertEquals(10, emp1.getEmpId());
			assertEquals("Ravi", emp1.getEmpName());
			
		}
		
		
		@Test
		void testUpdateEmployeeName() {
			Employee emp = new Employee();
			emp.setEmpId(10);
			emp.setEmpName("Ravi");
			
			Employee updatedEmp = new Employee();
			updatedEmp.setEmpId(10);
			updatedEmp.setEmpName("Sam");
			
			Mockito.when(empRepo.findById(10)).thenReturn(Optional.of(emp));
			Mockito.when(empRepo.save(emp)).thenReturn(updatedEmp);
			
			Employee emp2  =empServ.updateEmployeeName(10, "Sam");
			assertEquals("Sam", emp2.getEmpName());
		}
		
		@Test
		void testAddEmployee() {
			Employee emp = new Employee();
			emp.setEmpId(10);
			emp.setEmpName("Ravi");
			
			Mockito.when(empRepo.save(emp)).thenReturn(emp);
			Employee emp1= empServ.addEmployee(emp);
			assertEquals("Ravi", emp1.getEmpName());
		}
		
		@Test
		void testDeleteEmployee() {
			Employee emp = new Employee();
			emp.setEmpId(10);
			emp.setEmpName("Ravi");
			
			Mockito.when(empRepo.findById(10)).thenReturn(Optional.of(emp));
			//Mockito.when(empRepo.deleteById(10)).
			Employee emp1= empServ.deleteEmployee(10);
			assertEquals(10, emp1.getEmpId());
			
		}
		

}
