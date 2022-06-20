package com.example.spring.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.spring.entity.Address;
import com.example.spring.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// Custome query methods
	List<Employee> findByEmpName(String name);
	List<Employee> findBySalary(double salary);
	List<Employee> findBySalaryGreaterThan(double salary);
	

	// JPQL example
	//@Query("select e from Employee e where dob=:doBirth")
	List<Employee> findByDob(@Param("doBirth") LocalDate dob);
	
	// find addr based on emp id
	// Native Query example
	//@Query(value="select address.addr_id, address.city, address.state from employee inner join address on employee.emp_id=emp_addr_fk where employee.emp_id=:id", nativeQuery=true)
	
	
	
	
	
}
