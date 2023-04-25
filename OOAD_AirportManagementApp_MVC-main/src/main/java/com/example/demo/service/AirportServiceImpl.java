package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Airport;
import com.example.demo.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List < Airport > getAllAirports() {

        return airportRepository.findAll();
    }


    @Override
    public void saveAirport(Airport airport) {
        this.airportRepository.save(airport);
    }


    @Override
    public Airport getAirportById(String airport_name) {
        Optional < Airport > optional = airportRepository.findById(airport_name);
        Airport airport = null;
        if (optional.isPresent()) {
            airport = optional.get();
        } else {
            throw new RuntimeException(" Airport not found for airport name :: " + airport_name);
        }
        return airport;
    }

    @Override
    public void deleteAirportById(String airport_name) {
        this.airportRepository.deleteById(airport_name);
    }
}