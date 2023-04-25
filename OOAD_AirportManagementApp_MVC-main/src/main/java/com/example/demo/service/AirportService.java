package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Airport;

public interface AirportService {
    List < Airport > getAllAirports();
    void saveAirport(Airport airport);
    Airport getAirportById(String airport_name);
    void deleteAirportById(String airport_name);
}