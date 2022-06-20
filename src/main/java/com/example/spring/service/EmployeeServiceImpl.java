package com.example.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.AddressDto;
import com.example.spring.entity.Address;
import com.example.spring.entity.Employee;
import com.example.spring.entity.Skill;
import com.example.spring.exception.EmployeeNotFoundException;
import com.example.spring.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	IEmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpById(int empId) throws EmployeeNotFoundException {
		Optional<Employee> emp= empRepo.findById(empId);
		if(emp.isPresent()) {
			return emp.get();
		} else {
			throw new EmployeeNotFoundException("Employee not found with emp id "+empId);
		}
		
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public Employee updateEmployeeById(int empId, Employee emp) throws EmployeeNotFoundException {
		// find emp based on id
		Optional<Employee> dbEmp = empRepo.findById(empId);
		
		// if emp present, update emp with new details else return exception/null
		if(dbEmp.isPresent()) {
			return empRepo.save(emp);
		} else {
			throw new EmployeeNotFoundException("Employee not found with emp id "+empId);
		}
	}

	@Override
	public Employee deleteEmployee(int empId) {
		// find emp based on emp id
		Optional<Employee> emp = empRepo.findById(empId);
		
		// delete emp if present else return null or throw exception
		if(emp.isPresent()) {
			empRepo.deleteById(empId);
		} else {
			return null;
		}
		// return emp
		return emp.get();
	}

	
	// update emp name
	@Override
	public Employee updateEmployeeName(int empId, String newName) {
		// find emp by id
		Optional<Employee> emp= empRepo.findById(empId); // 2, Shiva
		if(emp.isPresent()) {
			// update name
			Employee dbEmp = emp.get();
			dbEmp.setEmpName(newName);
			return empRepo.save(dbEmp);
		} else {
			// if emp not found in db, return null or throw exception
			return null;
		}
		
	}

	
	// Update emp address
	@Override
	public Employee updateEmpAddr(int empId, Address newAddr) {
		// find emp
		Optional<Employee> emp = empRepo.findById(empId);
		if(emp.isPresent()) {
			// update addr
		    // get emp from optional container
			Employee dbEmp = emp.get();
			
			// add new addr to the existing emp
			dbEmp.getAddress().add(newAddr);
			System.out.println();
			
			
			// update emp details in db
			return empRepo.save(dbEmp);
		} else {
			return null;
		}
	}

	// Update employee skills
	@Override
	public Employee updateEmpSkill(int empId, Skill skill) {
		Optional<Employee> emp= empRepo.findById(empId);
		if(emp.isPresent()) {
			// update skills
			Employee dbEmp = emp.get();
			dbEmp.getSkills().add(skill);
			return empRepo.save(dbEmp);
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> getEmpByName(String empName) {
		
		return empRepo.findByEmpName(empName);
	}

	@Override
	public List<Employee> getEmpBySalary(double salary) {
		return empRepo.findBySalary(salary);
	}

	@Override
	public List<Employee> getEmpBySalaryGreaterThan(double salary) {
		return empRepo.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> getEmpByDob(LocalDate dob) {
		return empRepo.findByDob(dob);
	}

	
	

	@Override
	public List<Skill> getEmpSkills() {
		// logic to fetch emp skill
		return null;
	}

}
