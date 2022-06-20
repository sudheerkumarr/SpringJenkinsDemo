package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.AddressDto;
import com.example.spring.entity.Address;
import com.example.spring.service.IAddressService;

@RestController
public class AddressController {
	@Autowired
	IAddressService addrServ;

	// Get address based on emp id
	@GetMapping("/employee/addr/{empId}")
	ResponseEntity<Address> getAddressByEmpId(@PathVariable("empId") int empId) {
		Address addr = addrServ.getAddrByEmpId(empId);
		return new ResponseEntity<>(addr, HttpStatus.OK);
	}
}
