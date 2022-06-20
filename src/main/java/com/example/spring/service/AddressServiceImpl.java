package com.example.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.AddressDto;
import com.example.spring.entity.Address;
import com.example.spring.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addrRepo;

	// Get address by emp id
	@Override
	public Address getAddrByEmpId(int empId) {
		return addrRepo.getAddressByEmpId(empId);
	}

}
