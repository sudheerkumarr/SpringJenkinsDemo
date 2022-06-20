package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Skill;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer>{

}
