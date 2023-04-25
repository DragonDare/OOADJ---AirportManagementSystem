package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String>{

}

// extends JpaRepository<Airport, Long>