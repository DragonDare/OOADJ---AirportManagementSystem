package com.example.demo.repository;


import com.example.demo.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Integer>{

	Register findByEmail(String email); 
	
}
