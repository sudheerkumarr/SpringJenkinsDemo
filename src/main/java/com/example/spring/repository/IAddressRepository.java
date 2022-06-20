package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Integer> {

	// Native Query
	@Query(value="select * from address inner join employee on employee.emp_id=address.emp_addr_fk where emp_id=:id", nativeQuery=true)
	Address getAddressByEmpId(@Param("id") int empId);
}
