package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, String> {

}
